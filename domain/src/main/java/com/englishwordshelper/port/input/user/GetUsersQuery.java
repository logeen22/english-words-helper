package com.englishwordshelper.port.input.user;

import com.englishwordshelper.entity.user.User;

import java.util.List;

public interface GetUsersQuery {
    List<User> getUsers();
}
