package com.englishwordshelper.port.output.user;

import com.englishwordshelper.entity.user.SaveUserCommand;

public interface SaveUserPort {
    void saveUser(SaveUserCommand command);
}
