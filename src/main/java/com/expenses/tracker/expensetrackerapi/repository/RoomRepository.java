package com.expenses.tracker.expensetrackerapi.repository;

import com.expenses.tracker.expensetrackerapi.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
