//package com.englishwordshelper.groups;
//
//import com.englishwordshelper.groups.converter.GroupConverter;
//import com.englishwordshelper.groups.dto.GroupDto;
//import com.englishwordshelper.groups.dto.SaveGroupDto;
//import com.englishwordshelper.groups.dto.UpdateGroupDto;
//import com.englishwordshelper.port.input.group.DeleteGroupUseCase;
//import com.englishwordshelper.port.input.group.GetGroupsQuery;
//import com.englishwordshelper.port.input.group.SaveGroupUseCase;
//import com.englishwordshelper.port.input.group.UpdateGroupUseCase;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/groups")
//public class GroupsController {
//    private final GetGroupsQuery getGroupsQuery;
//    private final SaveGroupUseCase saveGroupUseCase;
//    private final UpdateGroupUseCase updateGroupUseCase;
//    private final DeleteGroupUseCase deleteGroupUseCase;
//    private final GroupConverter groupConverter;
//
//    public GroupsController(
//        GetGroupsQuery getGroupsQuery,
//        SaveGroupUseCase saveGroupUseCase,
//        UpdateGroupUseCase updateGroupUseCase,
//        DeleteGroupUseCase deleteGroupUseCase,
//        GroupConverter groupConverter
//    ) {
//        this.getGroupsQuery = getGroupsQuery;
//        this.saveGroupUseCase = saveGroupUseCase;
//        this.updateGroupUseCase = updateGroupUseCase;
//        this.deleteGroupUseCase = deleteGroupUseCase;
//        this.groupConverter = groupConverter;
//    }
//
//    @GetMapping
//    public List<GroupDto> getGroups() {
//        var groups = getGroupsQuery.getGroups();
//
//        return groupConverter.convert(groups);
//    }
//
//    @PostMapping
//    public void saveGroup(
//        @RequestBody SaveGroupDto saveGroupDto
//    ) {
//        var command = groupConverter.convertToCommand(
//            saveGroupDto
//        );
//
//        saveGroupUseCase.saveGroup(command);
//    }
//
//    @PutMapping("/{groupId}")
//    public void updateGroup(
//        @PathVariable int groupId,
//        @RequestBody UpdateGroupDto updateGroupDto
//    ) {
//        var command = groupConverter.convertToCommand(
//            groupId,
//            updateGroupDto
//        );
//
//        updateGroupUseCase.updateGroup(command);
//    }
//
//    @DeleteMapping("/{groupId}")
//    public void deleteGroup(@PathVariable int groupId) {
//        deleteGroupUseCase.deleteGroup(groupId);
//    }
//}
