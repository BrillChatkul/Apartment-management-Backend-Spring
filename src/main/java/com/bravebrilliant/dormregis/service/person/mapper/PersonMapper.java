package com.bravebrilliant.dormregis.service.person.mapper;

import com.bravebrilliant.dormregis.dto.person.PersonDetailDto;
import com.bravebrilliant.dormregis.dto.person.CreatePersonDto;
import com.bravebrilliant.dormregis.entities.Person;
import com.bravebrilliant.dormregis.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    public abstract Person createPersonToPerson(CreatePersonDto createPersonDto);

    @Mapping(source = "room", target = "roomId", qualifiedByName = "mapRoomId")
    public abstract PersonDetailDto personToPersonDetailDto(Person person);

    @Named("mapRoomId")
    public String mapRoomId(Room room){
        return room != null ? room.getRoomNo() : null;
    }
}
