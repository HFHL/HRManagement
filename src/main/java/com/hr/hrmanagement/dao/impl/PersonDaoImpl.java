package com.hr.hrmanagement.dao.impl;

import com.hr.hrmanagement.dao.PersonDao;
import com.hr.hrmanagement.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person findById(int id) {
        String sql = "SELECT * FROM person WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void save(Person person) {
        String sql = "INSERT INTO person (PASSWD, AUTHORITY, NAME, SEX, BIRTHDAY, DEPARTMENT, JOB, EDU_LEVEL, SPECIALTY, ADDRESS, TEL, EMAIL, STATE, REMARK) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.getPasswd(), person.getAuthority(), person.getName(), person.getSex(), person.getBirthday(), person.getDepartment(), person.getJob(), person.getEduLevel(), person.getSpecialty(), person.getAddress(), person.getTel(), person.getEmail(), person.getState(), person.getRemark());
    }

    @Override
    public void update(Person person) {
        String sql = "UPDATE person SET PASSWD = ?, AUTHORITY = ?, NAME = ?, SEX = ?, BIRTHDAY = ?, DEPARTMENT = ?, JOB = ?, EDU_LEVEL = ?, SPECIALTY = ?, ADDRESS = ?, TEL = ?, EMAIL = ?, STATE = ?, REMARK = ? WHERE ID = ?";
        jdbcTemplate.update(sql, person.getPasswd(), person.getAuthority(), person.getName(), person.getSex(), person.getBirthday(), person.getDepartment(), person.getJob(), person.getEduLevel(), person.getSpecialty(), person.getAddress(), person.getTel(), person.getEmail(), person.getState(), person.getRemark(), person.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM person WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Person> search(String query) {
        String sql = "SELECT * FROM person WHERE NAME LIKE ? OR ID LIKE ?";
        String queryParam = "%" + query + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam, queryParam}, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person findByName(String name) {
        String sql = "SELECT * FROM person WHERE NAME = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Person.class));
    }
}