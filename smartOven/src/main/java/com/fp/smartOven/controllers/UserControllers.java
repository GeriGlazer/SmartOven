package com.fp.smartOven.controllers;

import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartOven")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserControllers {

    @Autowired
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws CustomExceptions {
        String email = user.getEmail();
        return ResponseEntity.ok()
                .header("email", email)
                .body(userService.login(user));
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws CustomExceptions {
        userService.createNewUser(user);
        return ResponseEntity.ok()
                .body(user);
    }

    @PutMapping("/updateDetails")
    public ResponseEntity<?> updateDetails(@RequestBody User user) {
        userService.updateDetails(user);
        return ResponseEntity.ok()
                .body("User details updated");
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) throws CustomExceptions {
        userService.deleteUser(email);
        return ResponseEntity.ok()
                .body("User deleted");
    }

    @GetMapping("/userDetails")
    public ResponseEntity<?> getUserDetails() throws CustomExceptions {
        return ResponseEntity.ok()
                .body(userService.getUserDetails());
    }
}
