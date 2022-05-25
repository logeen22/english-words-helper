package com.englishwordshelper.users.dto;

public record UpdateUserDto(
    String firstName,
    String lastName,
    String email
) {
}
