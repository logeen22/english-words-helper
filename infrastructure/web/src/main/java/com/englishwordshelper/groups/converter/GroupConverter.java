package com.englishwordshelper.groups.converter;

import com.englishwordshelper.entity.group.Group;
import com.englishwordshelper.entity.group.SaveGroupCommand;
import com.englishwordshelper.entity.group.UpdateGroupCommand;
import com.englishwordshelper.groups.dto.GroupDto;
import com.englishwordshelper.groups.dto.SaveGroupDto;
import com.englishwordshelper.groups.dto.UpdateGroupDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupConverter {

    public List<GroupDto> convert(List<Group> groups) {
        return groups.stream().map(this::convert).toList();
    }

    public UpdateGroupCommand convertToCommand(
        int groupId,
        UpdateGroupDto updateGroupDto
    ) {
        return new UpdateGroupCommand(
            groupId,
            updateGroupDto.name()
        );
    }

    public SaveGroupCommand convertToCommand(
        SaveGroupDto saveGroupDto
    ) {
        return new SaveGroupCommand(
            saveGroupDto.name()
        );
    }

    public GroupDto convert(Group group) {
        return new GroupDto(
            group.id(),
            group.name()
        );
    }
}
