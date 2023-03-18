package com.example.codingbat.Controller;

import com.example.codingbat.Dto.UserStarCountDto;
import com.example.codingbat.Entity.UserStarCount;
import com.example.codingbat.Service.CategoryService;
import com.example.codingbat.Service.UserStarCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userStarCount")
public class UserStarCountController {
    @Autowired
    UserStarCountService userStarCountService;

    @GetMapping
    public List<UserStarCount> getUserStarCount() {
        return userStarCountService.getUserStarCount();
    }
    @PostMapping
    public ResponseEntity<Result> postUserStarCount(@RequestBody UserStarCountDto userStarCountDto) {
        Result result = userStarCountService.postUserStarCount(userStarCountDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putUserStarCount(@PathVariable Integer id,@RequestBody UserStarCountDto userStarCountDto) {
        Result result = userStarCountService.putUserStarCount(id,userStarCountDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserStarCount(@PathVariable Integer id)  {
        Result result = userStarCountService.deleteUserStarCount(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

}
