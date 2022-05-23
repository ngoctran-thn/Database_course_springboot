package fi.vamk.tka.springboot;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @GetMapping("/person/{id}")
    //Try http://localhost/person/5
    public Optional<Person> getPerson(@PathVariable("id") int id){
        return repository.findById(id);
    }

    @GetMapping("/persons")
    //Try http://localhost/persons
    public Iterable<Person> getPersons(){
        return repository.findAll();
    }
    //insert = save
    @PostMapping("/person")
    //Use postman and url http://localhost/person, method POST and put {"name":"Test"} in body
    public Person save(@RequestBody Person person){
        return repository.save(person);
    }

    //update = save
    @PutMapping("/person")
    //Use postman and url http://localhost/person, method PUT and put {"id":6, "name":"Test2"} in body
    public Person update(@RequestBody Person person){
        return repository.save(person);
    }

    @DeleteMapping("/person")
    //Use postman and url http://localhost/person, method DELETE and put {"id":6} in body
    public void delete(@RequestBody Person person){
        repository.delete(person);
    }
    
}
