package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.repository.RootsRepository;
import org.example.repository.UserRepository;

import java.util.*;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RootsRepository rootsRepository;
    public boolean checkPassword(String username, String password){
        Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername(username);

        if(userEntity.isPresent()){
            UserEntity user = userEntity.get();
            if (user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public List<String> getDistinctDates(String username){
        List<String> list = rootsRepository.findDistinctCreatedDates(username);
        return list;
    }
}
