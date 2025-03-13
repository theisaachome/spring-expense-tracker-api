package com.expenses.tracker.expensetrackerapi.service;

import java.util.List;

public interface BaseService <T,ID,RequestDto,ResponseDto>{
        ResponseDto findById(ID id);
        List<ResponseDto> findAll();
        ResponseDto save(RequestDto requestDto);
        ResponseDto update(ID id, RequestDto requestDto);
        void delete(ID id);

}
