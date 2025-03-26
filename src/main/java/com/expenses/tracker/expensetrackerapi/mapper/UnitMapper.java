package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.UnitRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.UnitResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper implements EntityMapper<Unit, UnitRequestDTO, UnitResponseDTO> {
    @Override
    public Unit toEntity(UnitRequestDTO dto) {
        Unit unit = new Unit();
        unit.setName(dto.name());
        unit.setAddress1(dto.address1());
        unit.setAddress2(dto.address2());
        return unit;
    }

    @Override
    public UnitResponseDTO toResponseDto(Unit entity) {
        return new UnitResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getAddress1(),
                entity.getAddress2(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate(),
                entity.getCreatedBy(),
                entity.getLastModifiedBy(),
                entity.getIsActive(),
                entity.getVersion()
        );
    }
}
