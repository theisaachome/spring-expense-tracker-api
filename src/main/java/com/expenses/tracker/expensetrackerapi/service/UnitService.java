package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.RoomRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.request.UnitRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.UnitResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Room;
import com.expenses.tracker.expensetrackerapi.entity.Unit;
import com.expenses.tracker.expensetrackerapi.mapper.UnitMapper;
import com.expenses.tracker.expensetrackerapi.repository.RoomRepository;
import com.expenses.tracker.expensetrackerapi.repository.UnitRepository;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UnitService extends BaseServiceImpl<Unit,Long, UnitRequestDTO, UnitResponseDTO> {

    private final RoomRepository roomRepository;

    public UnitService(UnitRepository repository, UnitMapper unitMapper, RoomRepository roomRepository) {
        super(repository,unitMapper);
        this.roomRepository =roomRepository;
    }
    @Override
    protected void updateEntity(Unit existingEntity, UnitRequestDTO dto) {
        existingEntity.setName(dto.name());
        existingEntity.setAddress1(dto.address1());
        existingEntity.setAddress2(dto.address2());
    }

    // add a room to a unit.
    public String addRoomToUnit(RoomRequestDTO dto,Long unitId){
        var unit = repository.getById(unitId);
        var room = new Room();
        room.setName(dto.name());
        room.setDescription(dto.description());
        room.setRoomType(dto.roomType());
        room.setUnit(unit);
        roomRepository.save(room);

        return "Room Saved Successfully";
    }
}
