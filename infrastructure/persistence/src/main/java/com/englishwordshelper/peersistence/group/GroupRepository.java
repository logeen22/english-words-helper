package com.englishwordshelper.peersistence.group;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GroupRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
