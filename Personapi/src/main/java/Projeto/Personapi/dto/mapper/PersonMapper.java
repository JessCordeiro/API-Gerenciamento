package Projeto.Personapi.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Projeto.Personapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}