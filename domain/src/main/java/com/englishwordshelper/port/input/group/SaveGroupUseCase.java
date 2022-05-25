package com.englishwordshelper.port.input.group;

import com.englishwordshelper.entity.group.SaveGroupCommand;

public interface SaveGroupUseCase {
    void saveGroup(SaveGroupCommand group);
}
