package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Employee;

public class ImplEmployeeDAO implements IEmployeeDAO {

	private Connection mCnn;

	public ImplEmployeeDAO() {
		mCnn = DatabaseHelper.getConnection();
	}
	
	@Override
	public List<Employee> select() {
		String sql = "SELECT e.*, d.department_name, p.position_name, s.salary_amount "
				+ "FROM Employees e "
				+ "INNER JOIN Departments d ON e.department_id = d.department_id "
				+ "INNER JOIN Positions p ON e.position_id = p.position_id "
				+ "INNER JOIN Salary s ON s.employee_id = e.employee_id;";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			List<Employee> lst = new ArrayList<>();
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String date_of_birth = rs.getString("date_of_birth");
				String hire_date = rs.getString("hire_date");
				int department_id = rs.getInt("department_id");
				int position_id = rs.getInt("position_id");
				String department_name = rs.getString("department_name");
                String position_name = rs.getString("position_name");
                Double salary_amount = rs.getDouble("salary_amount");
                
				Employee eItem = new Employee(employee_id, first_name, last_name, date_of_birth, hire_date ,department_id, position_id, department_name, position_name, salary_amount);
				lst.add(eItem);
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT e.*, d.department_name, p.position_name, s.salary_amount " + "FROM Employees e "
				+ "INNER JOIN Departments d ON e.department_id = d.department_id "
				+ "INNER JOIN Positions p ON e.position_id = p.position_id "
				+ "INNER JOIN Salary s ON s.employee_id = e.employee_id " + "WHERE e.employee_id = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String date_of_birth = rs.getString("date_of_birth");
				String hire_date = rs.getString("hire_date");
				int department_id = rs.getInt("department_id");
				int position_id = rs.getInt("position_id");
				String department_name = rs.getString("department_name");
				String position_name = rs.getString("position_name");
				Double salary_amount = rs.getDouble("salary_amount");

				Employee eItem = new Employee(employee_id, first_name, last_name, date_of_birth, hire_date,
						department_id, position_id, department_name, position_name, salary_amount);
				return eItem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		String sql = "INSERT INTO Employees(first_name, last_name, date_of_birth, hire_date, department_id, position_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, employee.getFirst_name());
			ps.setString(2, employee.getFirst_name());
			ps.setString(3, employee.getDate_of_birth());
			ps.setString(4, employee.getHire_date());
			ps.setInt(5, employee.getDepartment_id());
			ps.setInt(6, employee.getPosition_id());
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateEmployee(Employee employee) {
		String sql = "UPDATE Employees SET first_name = ?, last_name = ?, date_of_birth = ?, hire_date = ?, department_id = ?, position_id = ? WHERE employee_id = ?";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, employee.getFirst_name());
			ps.setString(2, employee.getLast_name());
			ps.setString(3, employee.getDate_of_birth());
			ps.setString(4, employee.getHire_date());
			ps.setInt(5, employee.getDepartment_id());
			ps.setInt(6, employee.getPosition_id());
			ps.setInt(7, employee.getEmployee_id());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteEmployee(int id) {
		String sql = "DELETE FROM Employees WHERE employee_id = ?";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
