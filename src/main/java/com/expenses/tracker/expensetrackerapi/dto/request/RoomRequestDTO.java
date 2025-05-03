package com.expenses.tracker.expensetrackerapi.dto.request;

import com.expenses.tracker.expensetrackerapi.entity.RoomType;

public record RoomRequestDTO(
        String name,
        String description,
        RoomType roomType
) {
}
