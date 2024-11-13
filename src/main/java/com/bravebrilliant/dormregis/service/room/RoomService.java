package com.bravebrilliant.dormregis.service.room;

import com.bravebrilliant.dormregis.dto.RoomDto;
import com.bravebrilliant.dormregis.entities.Room;
import com.bravebrilliant.dormregis.exception.NotFoundStatusException;
import com.bravebrilliant.dormregis.repository.RoomRepository;
import com.bravebrilliant.dormregis.service.room.mapper.RoomMapper;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public Page<Room> getRooms(){
        Pageable pageAble = PageRequest.of(0, 10);
        return this.roomRepository.findAllWithPagination(pageAble);
    }

    public Room findByRoomNo(String roomNo){
        Optional<Room> room = roomRepository.findByRoomNo(roomNo);
        if(room.isPresent()){
            return room.get();
        }else{
            throw new NotFoundStatusException("room not found");
        }
    }

    public Room saveRoom(RoomDto roomDto) throws ValidationException {
        Room room = roomMapper.roomDtoToRoom(roomDto);
        if(this.isRoomExist(room.getRoomNo())){
            throw new ValidationException("roomNo "+room.getRoomNo()+" is duplicated");
        }
        return roomRepository.save(room);
    }

    public Boolean isRoomExist(String roomNo){
        return roomNo != null && roomRepository.findByRoomNo(roomNo).isPresent();
    }
}
