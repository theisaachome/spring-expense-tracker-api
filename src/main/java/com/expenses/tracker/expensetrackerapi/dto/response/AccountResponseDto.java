package com.expenses.tracker.expensetrackerapi.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountResponseDto(
        String name,
        String type,
        BigDecimal balance,
        Long userId,
        BaseResponse baseResponse
) {
}
