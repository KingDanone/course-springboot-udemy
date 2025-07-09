package br.com.KingDanone.service;


import br.com.KingDanone.data.dto.PersonDTO;
import br.com.KingDanone.exception.ResourceNotFoundException;
import br.com.KingDanone.model.Person;
import br.com.KingDanone.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static br.com.KingDanone.mapper.ObjectMapper.parseObject;
import static br.com.KingDanone.mapper.ObjectMapper.parseListObjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class PersonServices {


    private final AtomicLong counter = new AtomicLong();
    final PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public List<PersonDTO> findAll() {
        log.info("finding all peoples");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        log.info("finding one Person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        log.info("Creating one Person");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO dto){

        log.info("Updating one Person");

        Person entity = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("This Person not exist on Data Source"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        log.info("Deleting one Person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("this ID does not exist in the Data Source"));
        repository.deleteById(id);
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Much Male");
        return person;
    }
}
