package com.englishwordshelper.users.converter;

import com.englishwordshelper.entity.user.SaveUserCommand;
import com.englishwordshelper.entity.user.UpdateUserCommand;
import com.englishwordshelper.entity.user.User;
import com.englishwordshelper.users.dto.SaveUserDto;
import com.englishwordshelper.users.dto.UpdateUserDto;
import com.englishwordshelper.users.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {

    public List<UserDto> convert(List<User> users) {
        return users.stream().map(this::convert).toList();
    }

    public UserDto convert(User userDto) {
        return new UserDto(
            userDto.id(),
            userDto.firstName(),
            userDto.lastName(),
            userDto.email()
        );
    }

    public SaveUserCommand convertToCommand(SaveUserDto saveUserDto) {
        return new SaveUserCommand(
            saveUserDto.firstName(),
            saveUserDto.lastName(),
            saveUserDto.email()
        );
    }

    public UpdateUserCommand convertToCommand(
        int userId,
        UpdateUserDto updateUserDto
    ) {
        return new UpdateUserCommand(
            userId,
            updateUserDto.firstName(),
            updateUserDto.lastName(),
            updateUserDto.email()
        );
    }
}
