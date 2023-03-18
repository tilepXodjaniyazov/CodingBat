package com.example.codingbat.Controller;

import com.example.codingbat.Dto.CategoryDto;
import com.example.codingbat.Dto.CompletedTaskDto;
import com.example.codingbat.Entity.Category;
import com.example.codingbat.Entity.CompletedTask;
import com.example.codingbat.Service.CategoryService;
import com.example.codingbat.Service.CompletedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/completedTask")
public class CompletedTaskController {
    @Autowired
    CompletedTaskService completedTaskService;

    @GetMapping
    public List<CompletedTask> getCompletedTask() {
        return completedTaskService.getcompletedTask();
    }
    @PostMapping
    public ResponseEntity<Result> postCompletedTask(@RequestBody CompletedTaskDto completedTaskDto) {
        Result result = completedTaskService.postCompletedTask(completedTaskDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putCompletedTask(@PathVariable Integer id, @RequestBody CompletedTaskDto completedTaskDto) {
        Result result = completedTaskService.putCompletedTask(id,completedTaskDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompletedTask(@PathVariable Integer id)  {
        Result result = completedTaskService.deleteCompletedTask(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
}
