//package com.englishwordshelper.users;
//
//import com.englishwordshelper.port.input.user.DeleteUserUseCase;
//import com.englishwordshelper.port.input.user.GetUsersQuery;
//import com.englishwordshelper.port.input.user.SaveUserUseCase;
//import com.englishwordshelper.port.input.user.UpdateUserUseCase;
//import com.englishwordshelper.users.converter.UserConverter;
//import com.englishwordshelper.users.dto.SaveUserDto;
//import com.englishwordshelper.users.dto.UpdateUserDto;
//import com.englishwordshelper.users.dto.UserDto;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/users")
//public class UsersController {
//    private final GetUsersQuery getUsersQuery;
//    private final SaveUserUseCase saveUserUseCase;
//    private final UpdateUserUseCase updateUserUseCase;
//    private final DeleteUserUseCase deleteUserUseCase;
//    private final UserConverter userConverter;
//
//    public UsersController(
//        GetUsersQuery getUsersQuery,
//        SaveUserUseCase saveUserUseCase,
//        UpdateUserUseCase updateUserUseCase,
//        DeleteUserUseCase deleteUserUseCase,
//        UserConverter userConverter
//    ) {
//        this.getUsersQuery = getUsersQuery;
//        this.saveUserUseCase = saveUserUseCase;
//        this.updateUserUseCase = updateUserUseCase;
//        this.deleteUserUseCase = deleteUserUseCase;
//        this.userConverter = userConverter;
//    }
//
//    @GetMapping
//    public List<UserDto> getUsers() {
//        var users = getUsersQuery.getUsers();
//        return userConverter.convert(users);
//    }
//
//    @PostMapping
//    public void saveUser(@RequestBody SaveUserDto saveUserDto) {
//        var command = userConverter.convertToCommand(saveUserDto);
//        saveUserUseCase.saveUser(command);
//    }
//
//    @PutMapping("/{userId}")
//    public void updateUser(
//        @PathVariable int userId,
//        @RequestBody UpdateUserDto updateUserDto
//    ) {
//        var command = userConverter.convertToCommand(
//            userId,
//            updateUserDto
//        );
//
//        updateUserUseCase.updateUser(command);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable int userId) {
//        deleteUserUseCase.deleteUser(userId);
//    }
//}
