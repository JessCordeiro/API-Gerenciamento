package Projeto.Personapi.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.Personapi.dto.mapper.PersonMapper;
import Projeto.Personapi.dto.request.PersonDTO;
import Projeto.Personapi.dto.response.MessageResponseDTO;
import Projeto.Personapi.entity.Person;
import Projeto.Personapi.exception.PersonNotFoundException;
import Projeto.Personapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository = null;

	private final PersonMapper personMapper = null;
	
	

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = (MessageResponseDTO) createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = (MessageResponseDTO) createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private Object createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder();
              
    }
}