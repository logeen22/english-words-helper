package com.englishwordshelper.port.output.group;

import com.englishwordshelper.entity.group.UpdateGroupCommand;

public interface UpdateGroupPort {
    void updateGroup(UpdateGroupCommand command);
}
