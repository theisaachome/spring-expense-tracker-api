package com.expenses.tracker.expensetrackerapi.controller;
import com.expenses.tracker.expensetrackerapi.dto.request.UserRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.UserResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.User;
import com.expenses.tracker.expensetrackerapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends AbstractController<User,Long, UserRequestDto,UserResponseDto> {
    private final UserService userService;
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }


    @DeleteMapping("/{userId}/clear-sample-data")
    public ResponseEntity<String> clearSampleData(@PathVariable Long userId) {
            this.userService.clearSampleData(userId);
           return  new ResponseEntity<String>("Sample Data removed", HttpStatus.ACCEPTED);
    }
}
