package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.UserDto;
import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import com.hospital.hospital_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setParola(userDto.getPassword());
        user.setUtip(userDto.getUtip());

    }

//    @Override
//    public List<UserDto> findAllUser() {
//        List<User> user=userRepository.findAll();
//        return user.stream()
//                .map(user1 -> mapToUser(user1))
//                .collect(Collectors.toList());
//    }

//    private UserDto mapToUser(User user1) {
//        UserDto userDto=UserDto.builder()
//                .id_user(user1.getIdUser())
//                .uname(user1.getIdUser())
//                .parola(user1.getIdUser())
//                .utip(user1.getIdUser())
//                .build();
//        return userDto;
//    }


}
