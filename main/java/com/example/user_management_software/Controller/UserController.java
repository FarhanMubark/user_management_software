package com.example.user_management_software.Controller;

import com.example.user_management_software.ApiResponse.ApiResponse;
import com.example.user_management_software.Model.User;
import com.example.user_management_software.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        List<User> userList = userService.getAllusers();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addusers(user);

        return ResponseEntity.status(200).body(new ApiResponse("user Added!"));
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity addUsers(@PathVariable int id,@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUsers(id, user);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("user updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User id Not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable int id){
        boolean isDeleted = userService.deleteUsers(id);

        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted!"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("user Id not found!"));
    }


}
