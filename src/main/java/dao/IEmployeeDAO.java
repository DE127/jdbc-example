package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDAO {
	public List<Employee> select();
	
	Employee getEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean updateEmployee(Employee employee);
	
	boolean deleteEmployee(int id);
}
