package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.RoomRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.request.UnitRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.UnitResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Unit;
import com.expenses.tracker.expensetrackerapi.service.UnitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/units")
public class UnitController extends AbstractController<Unit,Long, UnitRequestDTO, UnitResponseDTO> {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        super(unitService);
        this.unitService = unitService;
    }

    //Adding a Room to a Unit
    @PostMapping("/{unitId}/rooms")
    public String addRoomToUnit( @PathVariable Long unitId,@RequestBody RoomRequestDTO roomrequestDto){
       var result= this.unitService.addRoomToUnit(roomrequestDto, unitId);
       return result;
    }
    //   @PutMapping("/{unitId}/rooms/{roomId}")

    // 🗑 Delete a Room from a Unit
//    @DeleteMapping("/{unitId}/rooms/{roomId}")

}
