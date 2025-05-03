package com.expenses.tracker.expensetrackerapi.dto.response;
import com.expenses.tracker.expensetrackerapi.entity.Room;
import java.time.LocalDateTime;
import java.util.List;

public record UnitResponseDTO(
        Long id,
        String name,
        String address1,
        String address2,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version
//        List<Room> rooms
) {
}
