package com.notification.springnotification.authentication.service.impl;

import com.notification.springnotification.authentication.dto.request.UserRegistrationRequest;
import com.notification.springnotification.authentication.dto.request.UserUpdateRequest;
import com.notification.springnotification.authentication.dto.response.UserResponse;
import com.notification.springnotification.authentication.mapper.UserMapper;
import com.notification.springnotification.authentication.model.User;
import com.notification.springnotification.authentication.repo.UserRepository;
import com.notification.springnotification.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:51 PM
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public Long create(UserRegistrationRequest request) {
        User user = userMapper.requestToEntity(request);
        return userRepository.save(user).getId();
    }

    @Override
    public Long update(UserUpdateRequest updateRequest) {
        User persistedUser = userRepository.findById(updateRequest.id()).orElseThrow();
        User updatedUser = userMapper.partialUpdate(updateRequest, persistedUser);
        return userRepository.save(updatedUser).getId();
    }

    @Override
    public void delete(Long userId) {
        // Todo: check and throw exception if id not found
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse getSingle(Long id) {
        return userMapper.entityToResponse(userRepository.findById(id).orElseThrow());

    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
