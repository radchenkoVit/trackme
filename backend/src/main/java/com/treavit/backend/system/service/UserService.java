package com.treavit.backend.system.service;

import com.treavit.backend.system.dto.UserDto;
import com.treavit.backend.system.entity.User;
import com.treavit.backend.system.repository.UserRepository;
import com.treavit.backend.system.utils.UserDtoToEntityConvector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final UserDtoToEntityConvector dtoToEntityConvector;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserDtoToEntityConvector dtoToEntityConvector) {
        this.userRepository = userRepository;
        this.dtoToEntityConvector = dtoToEntityConvector;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(UserDto userDto) throws IOException {
        User user = dtoToEntityConvector.convertToEntity(userDto);//TODO: Taras, is it ok?
        return userRepository.save(user);
    }
}
