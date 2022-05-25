package com.englishwordshelper.entity.user;

public record User(
    int id,
    String firstName,
    String lastName,
    String email
) {
}
