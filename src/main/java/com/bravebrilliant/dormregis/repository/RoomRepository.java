package com.bravebrilliant.dormregis.repository;

import com.bravebrilliant.dormregis.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    @Query("SELECT r FROM Room r")
    Page<Room> findAllWithPagination(Pageable pageable);

    Optional<Room> findByRoomNo(String roomNo);
}
