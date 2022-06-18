package com.englishwordshelper.port.output.user;

import com.englishwordshelper.entity.user.User;

import java.util.List;

public interface GetUsersPort {
    List<User> getUsers();
}
