package com.englishwordshelper.entity.user;

public record UpdateUserCommand(
    int userId,
    String firstName,
    String lastName,
    String email
) {
}
