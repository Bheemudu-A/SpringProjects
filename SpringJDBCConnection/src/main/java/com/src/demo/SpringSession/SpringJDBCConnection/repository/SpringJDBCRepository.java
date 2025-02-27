package com.src.demo.SpringSession.SpringJDBCConnection.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.src.demo.SpringSession.SpringJDBCConnection.model.Student;

@Repository
public class SpringJDBCRepository {

	@Autowired
	private JdbcTemplate temp;
	
	public JdbcTemplate getTemp() {
		return temp;
	}

	
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	public void save(Student s) {
		
		String sql = "insert into Student (roll_num, marks, name) values (?,?,?)";
		int rows = temp.update(sql, s.getRollNum(), s.getMarks(), s.getName());
		
		System.out.println("Saved the Data : "+rows);
	}

	public List<Student> findAll() {
			
		String sql =  "select * from Student";
		
		RowMapper<Student> rod = new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Student std = new Student();
				std.setRollNum(rs.getInt("roll_num"));
				std.setMarks(rs.getInt("marks"));
				std.setName(rs.getString("name"));
				
				return std;
			}
		};
		
		return temp.query(sql, rod);
	}
	
	
	//lamda expression for Functional interface
/*	RowMapper<Student> rod = (rs, rowNum) -> {
			
			Student std = new Student();
			std.setRollNum(rs.getInt("roll_num"));
			std.setMarks(rs.getInt("marks"));
			std.setName(rs.getString("name"));
			
			return std;
		};*/
	

}
