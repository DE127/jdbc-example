package dao;

import java.util.List;

import entity.Salary;

public interface ISalaryDAO {
	List<Salary> getAllSalary();
	
	Salary getSalaryId(int id);
	
	boolean addSalary(Salary salary);
	
	boolean updateSalary(Salary Salary);
	
	boolean deleteSalary(int id);
}
