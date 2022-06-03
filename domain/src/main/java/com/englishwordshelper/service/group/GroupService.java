package com.englishwordshelper.service.group;

import com.englishwordshelper.entity.group.Group;
import com.englishwordshelper.entity.group.SaveGroupCommand;
import com.englishwordshelper.entity.group.UpdateGroupCommand;
import com.englishwordshelper.port.input.group.DeleteGroupUseCase;
import com.englishwordshelper.port.input.group.GetGroupsQuery;
import com.englishwordshelper.port.input.group.SaveGroupUseCase;
import com.englishwordshelper.port.input.group.UpdateGroupUseCase;
import com.englishwordshelper.port.output.group.DeleteGroupPort;
import com.englishwordshelper.port.output.group.GetGroupsPort;
import com.englishwordshelper.port.output.group.SaveGroupPort;
import com.englishwordshelper.port.output.group.UpdateGroupPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GroupService implements DeleteGroupUseCase, GetGroupsQuery, SaveGroupUseCase, UpdateGroupUseCase {
    private final DeleteGroupPort deleteGroupPort;
    private final GetGroupsPort getGroupsPort;
    private final SaveGroupPort saveGroupPort;
    private final UpdateGroupPort updateGroupPort;

    GroupService(
        DeleteGroupPort deleteGroupPort,
        GetGroupsPort getGroupsPort,
        SaveGroupPort saveGroupPort,
        UpdateGroupPort updateGroupPort
    ) {
        this.deleteGroupPort = deleteGroupPort;
        this.getGroupsPort = getGroupsPort;
        this.saveGroupPort = saveGroupPort;
        this.updateGroupPort = updateGroupPort;
    }

    @Override
    public void deleteGroup(int id) {
        deleteGroupPort.deleteGroup(id);
    }

    @Override
    public List<Group> getGroups() {
        return getGroupsPort.getGroups();
    }

    @Override
    public void saveGroup(SaveGroupCommand command) {
        saveGroupPort.saveGroup(command);
    }

    @Override
    public void updateGroup(UpdateGroupCommand command) {
        updateGroupPort.updateGroup(command);
    }
}
