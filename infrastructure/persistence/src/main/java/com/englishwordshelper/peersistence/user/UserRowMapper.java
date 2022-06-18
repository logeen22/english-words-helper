package com.englishwordshelper.peersistence.user;

import com.englishwordshelper.entity.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
            rs.getInt("id"),
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getString("email")
        );
    }
}
