package com.englishwordshelper.peersistence.user;

import com.englishwordshelper.entity.user.SaveUserCommand;
import com.englishwordshelper.entity.user.UpdateUserCommand;
import com.englishwordshelper.entity.user.User;
import com.englishwordshelper.port.output.user.DeleteUserPort;
import com.englishwordshelper.port.output.user.GetUsersPort;
import com.englishwordshelper.port.output.user.SaveUserPort;
import com.englishwordshelper.port.output.user.UpdateUserPort;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements DeleteUserPort, GetUsersPort, SaveUserPort, UpdateUserPort {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRowMapper userRowMapper;

    public UserRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        UserRowMapper userRowMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public void deleteUser(int id) {
        var sql = "DELETE FROM users WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("id", id)
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public List<User> getUsers() {
        var sql = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public void saveUser(SaveUserCommand command) {
        var sql = "INSERT INTO users (first_name, last_name, email) VALUES(:firstName, :lastName, :email)";
        var parameters = Map.ofEntries(
            Map.entry("first_name", command.firstName()),
            Map.entry("last_name", command.lastName()),
            Map.entry("email", command.email())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public void updateUser(UpdateUserCommand command) {
        var sql = "UPDATE users SET first_name = :firstName, last_name = :last_name, email = :email WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("first_name", command.firstName()),
            Map.entry("last_name", command.lastName()),
            Map.entry("email", command.email()),
            Map.entry("id", command.userId())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }
}
