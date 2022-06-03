package com.englishwordshelper.peersistence.group;

import com.englishwordshelper.entity.group.Group;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class GroupRowMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Group(
            rs.getInt("id"),
            rs.getString("name")
        );
    }
}
