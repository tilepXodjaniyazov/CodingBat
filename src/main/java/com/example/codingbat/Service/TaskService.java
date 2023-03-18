package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.TaskDto;
import com.example.codingbat.Entity.Category;
import com.example.codingbat.Entity.Task;
import com.example.codingbat.Entity.User;
import com.example.codingbat.Repository.CategoryRepository;
import com.example.codingbat.Repository.TaskRepository;
import com.example.codingbat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public Result postTask(TaskDto taskDto) {
        if (taskRepository.existsByName(taskDto.getName())) {
            Optional<Category> byId = categoryRepository.findById(taskDto.getCategoryId());
            User user = userRepository.findById(taskDto.getUserId()).get();
            Task task = new Task(null, taskDto.getName(), byId.get(), taskDto.getQuestion(), taskDto.getTemplate(), taskDto.getAnswerText(),
                    taskDto.getSolution(), user);
            taskRepository.save(task);
            return new Result("Saqlandi",true);
        }
        return new Result("Task mavjud",false);
    }

    public Result putTask(Integer id, TaskDto taskDto) {
        Optional<Task> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            Category category = categoryRepository.findById(taskDto.getCategoryId()).get();
            User user = userRepository.findById(taskDto.getUserId()).get();
            Task task = byId.get();
            task.setName(taskDto.getName());
            task.setCategory(category);
            task.setQuestion(taskDto.getQuestion());
            task.setTemplate(taskDto.getTemplate());
            task.setAnswerText(taskDto.getAnswerText());
            task.setSolution(taskDto.getSolution());
            task.setUser(user);
            taskRepository.save(task);
            return new Result("Ozgardi",true);
        }
        return new Result("topilmadi",false);
    }

    public Result deleteTask(Integer id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return new Result("ochirildi",true);
        }
        return new Result("topilmadi",false);
    }
}
