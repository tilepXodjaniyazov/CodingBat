package com.example.codingbat.Controller;

import com.example.codingbat.Dto.CategoryDto;
import com.example.codingbat.Dto.TaskDto;
import com.example.codingbat.Entity.Category;
import com.example.codingbat.Entity.Task;
import com.example.codingbat.Service.CategoryService;
import com.example.codingbat.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getTask() {
        return taskService.getTask();
    }
    @PostMapping
    public ResponseEntity<Result> postTask(@RequestBody TaskDto taskDto) {
        Result result = taskService.postTask(taskDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putTask(@PathVariable Integer id,@RequestBody TaskDto taskDto) {
        Result result = taskService.putTask(id,taskDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id)  {
        Result result = taskService.deleteTask(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

}
