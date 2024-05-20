package dao;

import java.util.List;

import entity.Department;

public interface IDepartmentDAO {
	public List<Department> select();

	Department getDepartmentById(int id);
	
	boolean addDepartment(Department department);
	
	boolean updateDepartment(Department department);
	
	boolean deleteDepartment(int id);
}
