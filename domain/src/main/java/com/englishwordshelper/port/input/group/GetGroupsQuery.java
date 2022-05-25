package com.englishwordshelper.port.input.group;

import com.englishwordshelper.entity.group.Group;

import java.util.List;

public interface GetGroupsQuery {
    List<Group> getGroups();
}
