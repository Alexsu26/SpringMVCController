package com.liyang.mvccontroller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DatabaseInitializer {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() throws SQLException {
        jdbcTemplate.update("DROP TABLE IF EXISTS roles");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS roles (" //
                + "id BIGINT IDENTITY NOT NULL PRIMARY KEY, " //
                + "name VARCHAR(100) NOT NULL, " //
                + "note VARCHAR(100) NOT NULL)");
        jdbcTemplate.update("insert into roles (name, note) values ('name1', 'note1')");
        jdbcTemplate.update("insert into roles (name, note) values ('name2', 'note2')");
    }
}
