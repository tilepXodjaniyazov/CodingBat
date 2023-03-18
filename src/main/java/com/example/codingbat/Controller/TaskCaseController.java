package com.example.codingbat.Controller;

import com.example.codingbat.Dto.TaskCaseDto;
import com.example.codingbat.Entity.TaskCase;
import com.example.codingbat.Service.TaskCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/taskCase")
public class TaskCaseController {
    @Autowired
    TaskCaseService taskCaseService;

    @GetMapping
    public List<TaskCase> getTaskCase() {
        return taskCaseService.getTaskCase();
    }
    @PostMapping
    public ResponseEntity<Result> postTaskCase(@RequestBody TaskCaseDto taskCaseDto) {
        Result result = taskCaseService.postTaskCase(taskCaseDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putTaskCase(@PathVariable Integer id, @RequestBody TaskCaseDto taskCaseDto) {
        Result result = taskCaseService.putTaskCase(id,taskCaseDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskCase(@PathVariable Integer id)  {
        Result result = taskCaseService.deleteTaskCase(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

}
