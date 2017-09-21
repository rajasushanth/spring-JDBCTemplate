package com.myorg.sush.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myorg.sush.bo.EmployeeBO;
import com.myorg.sush.dvo.EmployeeDVO;
import com.myorg.sush.javaconfig.JavaConfig;

public class ApplicationMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		EmployeeBO employeeBO = ctx.getBean(EmployeeBO.class);
		//System.out.println(employeeBO.getNumberOfEmployees());
		//System.out.println(employeeBO.getEmployeeById(10001));
		List<EmployeeDVO> employeeDVOlist = employeeBO.getEmployeesBetweenEmpID(10000, 10010);
		for(EmployeeDVO e: employeeDVOlist) {
			System.out.println(e);
		}
		ctx.close();
	}

}
