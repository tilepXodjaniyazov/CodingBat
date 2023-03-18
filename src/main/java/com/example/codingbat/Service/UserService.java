package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.UserDto;
import com.example.codingbat.Entity.User;
import com.example.codingbat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Result postUser(UserDto userDto) {
        if (userRepository.existsByEmailOrPassword(userDto.getEmail(), userDto.getPassword())) {
            return new Result("User mavjud", false);
        }
        User user = new User(null, userDto.getEmail(), userDto.getPassword());
        userRepository.save(user);
        return new Result("saqlandi", true);
    }

    public Result putUser(Integer id, UserDto userDto) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return new Result("Ozgartirildi", true);
        }
        return new Result("User topilmadi", false);
    }

    public Result deleteUser(Integer id) {
        try {
            if (!userRepository.existsById(id)) {
                return new Result("User topilmadi", false);
            }
            userRepository.deleteById(id);
            return new Result("Delete", true);
        } catch (Exception e) {
            return new Result("ERROR", false);
        }
    }
}
