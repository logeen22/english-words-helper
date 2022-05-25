package com.englishwordshelper.entity.user;

public record SaveUserCommand(
    String firstName,
    String lastName,
    String email
) {
}
