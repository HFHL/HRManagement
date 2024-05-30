package com.hr.hrmanagement.service.impl;

import com.hr.hrmanagement.entity.Log;
import com.hr.hrmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveLog(Log log) {
        String sql = "INSERT INTO log (description, timestamp) VALUES (?, ?)";
        jdbcTemplate.update(sql, log.getDescription(), log.getTimestamp());
    }

    @Override
    public List<Log> getAllLogs() {
        String sql = "SELECT * FROM log";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapLog(rs));
    }

    private Log mapLog(ResultSet rs) throws SQLException {
        Log log = new Log();
        log.setId(rs.getInt("id"));
        log.setDescription(rs.getString("description"));
        log.setTimestamp(rs.getTimestamp("timestamp"));
        return log;
    }
}