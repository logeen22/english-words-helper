package com.englishwordshelper.service.user;

import com.englishwordshelper.entity.user.SaveUserCommand;
import com.englishwordshelper.entity.user.UpdateUserCommand;
import com.englishwordshelper.entity.user.User;
import com.englishwordshelper.port.input.user.DeleteUserUseCase;
import com.englishwordshelper.port.input.user.GetUsersQuery;
import com.englishwordshelper.port.input.user.SaveUserUseCase;
import com.englishwordshelper.port.input.user.UpdateUserUseCase;
import com.englishwordshelper.port.output.user.DeleteUserPort;
import com.englishwordshelper.port.output.user.GetUsersPort;
import com.englishwordshelper.port.output.user.SaveUserPort;
import com.englishwordshelper.port.output.user.UpdateUserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserService implements DeleteUserUseCase, GetUsersQuery, SaveUserUseCase, UpdateUserUseCase {
    private final DeleteUserPort deleteUserPort;
    private final GetUsersPort getUsersPort;
    private final SaveUserPort saveUserPort;
    private final UpdateUserPort updateUserPort;

    UserService(
        DeleteUserPort deleteUserPort,
        GetUsersPort getUsersPort,
        SaveUserPort saveUserPort,
        UpdateUserPort updateUserPort
    ) {
        this.deleteUserPort = deleteUserPort;
        this.getUsersPort = getUsersPort;
        this.saveUserPort = saveUserPort;
        this.updateUserPort = updateUserPort;
    }

    @Override
    public void deleteUser(int id) {
        deleteUserPort.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return getUsersPort.getUsers();
    }

    @Override
    public void saveUser(SaveUserCommand command) {
        saveUserPort.saveUser(command);
    }

    @Override
    public void updateUser(UpdateUserCommand command) {
        updateUserPort.updateUser(command);
    }
}
