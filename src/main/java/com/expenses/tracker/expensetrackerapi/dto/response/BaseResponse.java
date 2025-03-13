package com.expenses.tracker.expensetrackerapi.dto.response;

import java.time.LocalDateTime;

public record BaseResponse(
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version
) {}
