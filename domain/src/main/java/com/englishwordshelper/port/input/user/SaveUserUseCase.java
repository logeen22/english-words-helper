package com.englishwordshelper.port.input.user;

import com.englishwordshelper.entity.user.SaveUserCommand;

public interface SaveUserUseCase {
    void saveUser(SaveUserCommand command);
}
