package com.englishwordshelper.port.output.user;

import com.englishwordshelper.entity.user.UpdateUserCommand;

public interface UpdateUserPort {
    void updateUser(UpdateUserCommand command);
}
