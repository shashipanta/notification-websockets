package com.notification.springnotification.authentication.mapper;

import com.notification.springnotification.authentication.dto.request.UserRegistrationRequest;
import com.notification.springnotification.authentication.dto.request.UserUpdateRequest;
import com.notification.springnotification.authentication.dto.response.UserResponse;
import com.notification.springnotification.authentication.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User requestToEntity(UserRegistrationRequest userRegistrationRequest);

    UserRegistrationRequest entityToRequest(User user);

    UserResponse entityToResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserUpdateRequest updateRequest, @MappingTarget User user);
}