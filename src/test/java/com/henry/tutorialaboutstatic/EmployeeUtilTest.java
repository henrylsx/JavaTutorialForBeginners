//package com.henry.tutorialaboutstatic;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.henrylsx.tutorial_02.about_static.Employee;
//import com.henrylsx.tutorial_02.about_static.EmployeeUtil;
//
//public class EmployeeUtilTest {
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testEmployeeWithEvenNumberEmployeeid() {
//		List<Employee> employeeList = new ArrayList<Employee>();
//		employeeList.addAll(Arrays.asList(new Employee(1,"Henry"), new Employee(2,"Jiawen")));	//calling a static method Arrays.asList
//		
//		List<Employee> employeeResult = EmployeeUtil.employeeWithEvenNumberEmployeeid(employeeList);
//		assert(employeeResult.size() ==1);
//		System.out.println(employeeResult.get(0));
//	}
//
//}
