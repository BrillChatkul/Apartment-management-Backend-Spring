package com.bravebrilliant.dormregis.service.room.mapper;

import com.bravebrilliant.dormregis.dto.RoomDto;
import com.bravebrilliant.dormregis.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    public abstract RoomDto roomToRoomDto(Room room);

    @Mapping(target = "detail", qualifiedByName = "mapDetail")
    public abstract Room roomDtoToRoom(RoomDto roomDto);

    @Named("mapDetail")
    public String mapDetail (String detail){
        return detail != null ? detail.toUpperCase() : null;
    }
}
