package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Controller.TaskCaseController;
import com.example.codingbat.Dto.TaskCaseDto;
import com.example.codingbat.Entity.TaskCase;
import com.example.codingbat.Repository.TaskCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCaseService {
    @Autowired
    TaskCaseRepository taskCaseRepository;

    public List<TaskCase> getTaskCase() {
        return taskCaseRepository.findAll();
    }

    public Result postTaskCase(TaskCaseDto taskCaseDto) {
        TaskCase taskCase = new TaskCase();
        taskCase.setTaskId(taskCaseDto.getTaskId());
        taskCase.setCaseText(taskCaseDto.getCaseText());
        taskCaseRepository.save(taskCase);
        return new Result("qoshildi", true);
    }

    public Result putTaskCase(Integer id, TaskCaseDto taskCaseDto) {
        Optional<TaskCase> byId = taskCaseRepository.findById(id);
        if (byId.isPresent()) {
            TaskCase taskCase = byId.get();
            taskCase.setTaskId(taskCaseDto.getTaskId());
            taskCase.setCaseText(taskCaseDto.getCaseText());
            taskCaseRepository.save(taskCase);
            return new Result("ozgardi", true);
        }
        return new Result("taskcase topilmadi", false);
    }

    public Result deleteTaskCase(Integer id) {
        try {
            taskCaseRepository.deleteById(id);
            return new Result("ochirildi", true);
        } catch (Exception e) {
            return new Result("ERROR!!", false);
        }
    }
}
