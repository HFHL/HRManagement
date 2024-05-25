package com.hr.hrmanagement.dao.impl;

import com.hr.hrmanagement.dao.PersonnelChangeDao;
import com.hr.hrmanagement.entity.PersonnelChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonnelChangeDaoImpl implements PersonnelChangeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PersonnelChange> findAll() {
        String sql = "SELECT * FROM PERSONNEL_CHANGE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PersonnelChange.class));
    }

    @Override
    public PersonnelChange findById(int id) {
        String sql = "SELECT * FROM PERSONNEL_CHANGE WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(PersonnelChange.class), id);
    }

    @Override
    public int save(PersonnelChange personnelChange) {
        String sql = "INSERT INTO PERSONNEL_CHANGE (PERSON, CHANGE_CODE, DESCRIPTION) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, personnelChange.getPerson(), personnelChange.getChangeCode(), personnelChange.getDescription());
    }

    @Override
    public int update(PersonnelChange personnelChange) {
        String sql = "UPDATE PERSONNEL_CHANGE SET PERSON = ?, CHANGE_CODE = ?, DESCRIPTION = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, personnelChange.getPerson(), personnelChange.getChangeCode(), personnelChange.getDescription(), personnelChange.getId());
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM PERSONNEL_CHANGE WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }
}