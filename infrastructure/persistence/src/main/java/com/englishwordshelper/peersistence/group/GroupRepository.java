package com.englishwordshelper.peersistence.group;

import com.englishwordshelper.entity.group.Group;
import com.englishwordshelper.entity.group.SaveGroupCommand;
import com.englishwordshelper.entity.group.UpdateGroupCommand;
import com.englishwordshelper.port.output.group.DeleteGroupPort;
import com.englishwordshelper.port.output.group.GetGroupsPort;
import com.englishwordshelper.port.output.group.SaveGroupPort;
import com.englishwordshelper.port.output.group.UpdateGroupPort;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
class GroupRepository implements DeleteGroupPort, GetGroupsPort, SaveGroupPort, UpdateGroupPort {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final GroupRowMapper groupRowMapper;

    public GroupRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        GroupRowMapper groupRowMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.groupRowMapper = groupRowMapper;
    }

    @Override
    public void deleteGroup(int id) {
        var sql = "DELETE FROM groups WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("id", id)
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public List<Group> getGroups() {
        var sql = "SELECT * FROM groups";
        return namedParameterJdbcTemplate.query(sql, groupRowMapper);
    }

    @Override
    public void saveGroup(SaveGroupCommand command) {
        var sql = "INSERT INTO groups (name) VALUES(:name)";
        var parameters = Map.ofEntries(
            Map.entry("name", command.name())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public void updateGroup(UpdateGroupCommand command) {
        var sql = "UPDATE groups SET name = :name WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("name", command.name()),
            Map.entry("id", command.groupId())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }
}
