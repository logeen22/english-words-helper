package com.englishwordshelper.port.input.group;

import com.englishwordshelper.entity.group.UpdateGroupCommand;

public interface UpdateGroupUseCase {
    void updateGroup(UpdateGroupCommand command);
}
