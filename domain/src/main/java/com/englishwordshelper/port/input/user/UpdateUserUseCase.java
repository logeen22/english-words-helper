package com.englishwordshelper.port.input.user;

import com.englishwordshelper.entity.user.UpdateUserCommand;
import com.englishwordshelper.entity.user.User;

public interface UpdateUserUseCase {
    void updateUser(UpdateUserCommand command);
}
