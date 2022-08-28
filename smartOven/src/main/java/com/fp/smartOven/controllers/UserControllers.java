package com.fp.smartOven.controllers;

import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartOven")
public class UserControllers {
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<?> login (@PathVariable String email) throws CustomExceptions {
        return ResponseEntity.ok()
                .body(userService.login(email));
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser (@RequestBody User user) throws CustomExceptions {
        userService.createNewUser(user);
        return ResponseEntity.ok()
                .body(user);
    }

    @PutMapping("/updateDetails")
    public ResponseEntity<?> updateDetails (@RequestBody User user){
        userService.updateDetails(user);
        return ResponseEntity.ok()
                .body("User details updated");
    }

    @DeleteMapping("/deleteUser/{mail}")
    public ResponseEntity<?> deleteUser (@PathVariable String email){
        userService.deleteUser(email);
        return ResponseEntity.ok()
                .body("User deleted");
    }
}
