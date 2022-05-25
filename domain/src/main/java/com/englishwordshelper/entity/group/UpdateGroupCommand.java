package com.englishwordshelper.entity.group;

public record UpdateGroupCommand(
    int groupId,
    String name
) {
}
