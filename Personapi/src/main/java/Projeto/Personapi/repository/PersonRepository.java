package Projeto.Personapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.Personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}