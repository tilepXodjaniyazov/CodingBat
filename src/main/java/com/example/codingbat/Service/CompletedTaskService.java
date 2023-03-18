package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.CompletedTaskDto;
import com.example.codingbat.Entity.CompletedTask;
import com.example.codingbat.Repository.CompletedTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompletedTaskService {
    @Autowired
    CompletedTaskRepository completedTaskRepository;

    public List<CompletedTask> getcompletedTask() {
        return completedTaskRepository.findAll();
    }

    public Result postCompletedTask(CompletedTaskDto completedTaskDto) {
        CompletedTask completedTask = new CompletedTask(null, completedTaskDto.getUserId(),
                completedTaskDto.getTaskId(), completedTaskDto.getIsCompleted(),
                completedTaskDto.getAnswerText(), completedTaskDto.getTestCaseCount());
        completedTaskRepository.save(completedTask);
        return new Result("saqlandi", true);
    }

    public Result putCompletedTask(Integer id, CompletedTaskDto completedTaskDto) {
        Optional<CompletedTask> byId = completedTaskRepository.findById(id);
        if (byId.isPresent()) {
            CompletedTask completedTask = byId.get();
            completedTask.setUserId(completedTaskDto.getUserId());
            completedTask.setTaskId(completedTaskDto.getTaskId());
            completedTask.setIsCompleted(completedTaskDto.getIsCompleted());
            completedTask.setAnswerText(completedTaskDto.getAnswerText());
            completedTask.setTestCaseCount(completedTaskDto.getTestCaseCount());
            completedTaskRepository.save(completedTask);
            return new Result("ozgardi",true);
        }
        return new Result("Topilmadi",false);
    }

    public Result deleteCompletedTask(Integer id) {
        if (completedTaskRepository.existsById(id)) {
            completedTaskRepository.deleteById(id);
            return new Result("delete",true);
        }
        return new Result("completedTask topilmadi",false);
    }

}
