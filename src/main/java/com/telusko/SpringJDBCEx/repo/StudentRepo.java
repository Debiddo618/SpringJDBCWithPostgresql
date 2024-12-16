package com.telusko.SpringJDBCEx.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.telusko.SpringJDBCEx.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows + " affected");
    }

    // Row Mapper helps you get data one by one from the resultset
    public List<Student> findAll() {
        // SQL query to select all records from the 'student' table
        String sql = "select * from student";
        
        // The query method executes the SQL and processes the ResultSet
        return jdbc.query(sql, (rs, rowNum) -> {
            // This lambda function is called for each row in the ResultSet
            
            // Create a new Student object
            Student s = new Student();
            
            // Set properties of the Student object based on the current row
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            
            // Return the Student object
            return s;
        });
    }
    

}
