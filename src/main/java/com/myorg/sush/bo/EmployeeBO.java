package com.myorg.sush.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.sush.dao.EmployeeDAO;
import com.myorg.sush.dvo.EmployeeDVO;

@Service
public class EmployeeBO {
	
	private EmployeeDAO employeeDAO;
	
	public int getNumberOfEmployees() {
		return employeeDAO.getEmployeesCount();
	}
	public EmployeeDVO getEmployeeById(int id) {
		return employeeDAO.getEmployeeByEmpId(id);
	}
	
	public List<EmployeeDVO> getEmployeesBetweenEmpID(int startId,int endId){
		return employeeDAO.getEmployeesBetweenEmpID(startId, endId);
	}
	
	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	

}
