package com.expenses.tracker.expensetrackerapi.dto.request;

import java.math.BigDecimal;

public record AccountRequestDto (
        String name,
        String type,
        BigDecimal balance,
        Long userId // Reference to the user owning the account
        ){
}
