package com.example.user_management_software.Service;

import com.example.user_management_software.Model.User;
import com.example.user_management_software.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllusers(){
        return userRepository.findAll();
    }

    public void addusers(User user){
        userRepository.save(user);
    }

    public Boolean updateUsers(Integer id, User user){
        User oldUser = userRepository.getById(id);

        if (oldUser==null){
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        oldUser.setUsername(user.getUsername());
        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUsers(Integer id){
        User userId = userRepository.getById(id);

        if (userId==null){
            return false;
        }

        userRepository.delete(userId);
        return true;
    }
}
