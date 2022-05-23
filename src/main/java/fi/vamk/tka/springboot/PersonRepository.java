package fi.vamk.tka.springboot;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
    
}

//insert into person (name) values ('Jukka');