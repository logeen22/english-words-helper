package com.englishwordshelper.port.output.group;

import com.englishwordshelper.entity.group.SaveGroupCommand;

public interface SaveGroupPort {
    void saveGroup(SaveGroupCommand command);
}
