package com.expenses.tracker.expensetrackerapi.mapper;

public interface EntityMapper<T,RequestDto,ResponseDto> {
    T toEntity(RequestDto requestDto);
    ResponseDto toResponseDto(T entity);
}
