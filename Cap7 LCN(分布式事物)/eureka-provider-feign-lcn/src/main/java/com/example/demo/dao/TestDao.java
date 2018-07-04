package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Test;

@Repository
public class TestDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    public int save() {
        String sql = "insert into t_test(name) values (?)";
        return jdbcTemplate.update(sql,"jdbc-hello-1");
    }

    public List<Test> list() {
        String sql = "select * from t_test ";
        return jdbcTemplate.query(sql, new RowMapper<Test>() {
            @Override
            public Test mapRow(ResultSet resultSet, int i) throws SQLException {
                Test test = new Test();
                test.setId(resultSet.getInt("id"));
                test.setName(resultSet.getString("name"));
                return test;
            }
        });
    }
}
