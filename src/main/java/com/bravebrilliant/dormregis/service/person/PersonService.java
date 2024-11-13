package com.bravebrilliant.dormregis.service.person;

import com.bravebrilliant.dormregis.dto.person.CreatePersonDto;
import com.bravebrilliant.dormregis.dto.person.PersonDetailDto;
import com.bravebrilliant.dormregis.entities.Person;
import com.bravebrilliant.dormregis.exception.NotFoundStatusException;
import com.bravebrilliant.dormregis.repository.PersonRepository;
import com.bravebrilliant.dormregis.service.person.mapper.PersonMapper;
import com.bravebrilliant.dormregis.service.room.RoomService;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;
    private final RoomService roomService;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository, RoomService roomService) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
        this.roomService = roomService;
    }

    public Person findByFirstName(String firstName){
        Optional<Person> person = this.personRepository.findByFirstName(firstName);
        if(person.isPresent()){
            return person.get();
        }else{
            throw new NotFoundStatusException("person not found");
        }
    }

    public PersonDetailDto createPerson(CreatePersonDto createPersonDto){
        if(this.isFirstNameExist(createPersonDto.getFirstName())){
            throw new ValidationException("firstName is duplicated");
        }
        Person person = this.personMapper.createPersonToPerson(createPersonDto);
        if(this.roomService.isRoomExist(createPersonDto.getRoomNo()))
        {
            person.setRoom(this.roomService.findByRoomNo(createPersonDto.getRoomNo()));
        }
        Person resPerson = this.personRepository.save(person);
        return this.personMapper.personToPersonDetailDto(resPerson);
    }

    public Boolean isFirstNameExist(String firstName){
        return this.personRepository.findByFirstName(firstName).isPresent();
    }

}
