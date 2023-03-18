package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.UserStarCountDto;
import com.example.codingbat.Entity.UserStarCount;
import com.example.codingbat.Repository.UserStarCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStarCountService {
    @Autowired
    UserStarCountRepository userStarCountRepository;
    public List<UserStarCount> getUserStarCount() {
        return userStarCountRepository.findAll();
    }

    public Result postUserStarCount(UserStarCountDto userStarCountDto) {
        UserStarCount userStarCount = new UserStarCount();
        userStarCount.setUserId(userStarCountDto.getUserId());
        userStarCount.setCategoryId(userStarCountDto.getCategoryId());
        userStarCount.setStarCount(userStarCountDto.getStarCount());
        return new Result("saqlandi",true);
    }

    public Result putUserStarCount(Integer id, UserStarCountDto userStarCountDto) {
        Optional<UserStarCount> byId = userStarCountRepository.findById(id);
        if (byId.isPresent()) {
            UserStarCount userStarCount = byId.get();
            userStarCount.setUserId(userStarCountDto.getUserId());
            userStarCount.setCategoryId(userStarCountDto.getCategoryId());
            userStarCount.setStarCount(userStarCountDto.getStarCount());
            userStarCountRepository.save(userStarCount);
            return new Result("ozgardi",true);
        }
        return new Result("topilmadi",false);
    }

    public Result deleteUserStarCount(Integer id) {
        try {
            if (userStarCountRepository.existsById(id)) {
                userStarCountRepository.deleteById(id);
                return new Result("ochirildi",false);
            }
        } catch (Exception e) {
            return new Result("ERROR",false);
        }
        return new Result("topilmadi",false);
    }
}
