package dev.powerit.onetomany.repository;

import dev.powerit.onetomany.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
