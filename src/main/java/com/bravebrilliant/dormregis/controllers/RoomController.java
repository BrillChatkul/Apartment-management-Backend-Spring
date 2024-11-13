package com.bravebrilliant.dormregis.controllers;

import com.bravebrilliant.dormregis.dto.RoomDto;
import com.bravebrilliant.dormregis.entities.Room;
import com.bravebrilliant.dormregis.service.room.RoomService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Hello") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/roomList")
    public Page<Room> getRoomList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int paginate) {
        return this.roomService.getRooms();
    }

    @GetMapping("/{roomNo}")
    public ResponseEntity<Room> getRoom(@PathVariable String roomNo){
        Room room = roomService.findByRoomNo(roomNo);
        return ResponseEntity.ok(room);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Room> createRoom(@Valid @RequestBody RoomDto newRoom){
        Room room = roomService.saveRoom(newRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
}
