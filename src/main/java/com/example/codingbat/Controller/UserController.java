package com.example.codingbat.Controller;

import com.example.codingbat.Dto.UserDto;
import com.example.codingbat.Entity.User;
import com.example.codingbat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }
    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody UserDto userDto) {
        Result result = userService.postUser(userDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putUser(@PathVariable Integer id,@RequestBody UserDto userDto) {
        Result result = userService.putUser(id,userDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        Result result = userService.deleteUser(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
}
