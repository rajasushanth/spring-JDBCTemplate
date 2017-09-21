package com.myorg.sush.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myorg.sush.dvo.EmployeeDVO;

@Repository
public class EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public int getEmployeesCount() {
		int a = jdbcTemplate.queryForObject("select count(*) from employees.employees", Integer.class);
		return a;
	}
	
	public List<EmployeeDVO> getEmployeesBetweenEmpID(int startId, int endId){
		return jdbcTemplate.query("select * from employees.employees e where e.emp_no between ? and ?", 
				new Object[] {startId, endId}, 
				//new BeanPropertyRowMapper<EmployeeDVO>(EmployeeDVO.class));
				new EmployeeRowMapper());
	}
	
	public EmployeeDVO getEmployeeByEmpId(int id) {
		return jdbcTemplate.queryForObject("select * from employees.employees e where e.emp_no = ?", 
				new Object[] {id},
				new BeanPropertyRowMapper<>(EmployeeDVO.class));
				//new EmployeeRowMapper());
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	class EmployeeRowMapper implements RowMapper<EmployeeDVO>{
		@Override
		public EmployeeDVO mapRow(ResultSet rs, int arg1) throws SQLException {
			EmployeeDVO employeeDVO = new EmployeeDVO();
			employeeDVO.setEmpNo(rs.getInt("emp_no"));
			employeeDVO.setBirthDate(rs.getDate("birth_date"));
			employeeDVO.setHireDate(rs.getDate("hire_date"));
			employeeDVO.setFirstName(rs.getString("first_name"));
			employeeDVO.setLastName(rs.getString("last_name"));
			employeeDVO.setGender(rs.getString("gender"));
			return employeeDVO;
		}
		
	}
	

}
