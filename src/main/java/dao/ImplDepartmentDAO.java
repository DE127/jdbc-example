package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Department;

public class ImplDepartmentDAO implements IDepartmentDAO {

	private Connection mCnn;

	public ImplDepartmentDAO() {
		mCnn = DatabaseHelper.getConnection();
	}
	
	@Override
	public List<Department> select() {
		String sql = "SELECT * FROM `Departments`";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			List<Department> lst = new ArrayList<>();
			while (rs.next()) {
				int department_id = rs.getInt("department_id");
				String department_name = rs.getString("department_name");

				Department dItem = new Department(department_id, department_name);
				lst.add(dItem);
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
	public Department getDepartmentById(int id) {
		String sql = "SELECT * FROM `Departments` WHERE department_id = ?";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			Department department = null;
			if (rs.next()) {
				int department_id = rs.getInt("department_id");
				String department_name = rs.getString("department_name");

				department = new Department(department_id, department_name);
			}
			return department;
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
	public boolean addDepartment(Department department) {
		String sql = "INSERT INTO `Departments` (department_name) VALUES (?)";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, department.getDepartment_name());
			
			return ps.executeUpdate() > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateDepartment(Department department) {
		String sql = "UPDATE `Departments` SET department_name = ? WHERE department_id = ?";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, department.getDepartment_name());
			ps.setInt(2, department.getDepartment_id());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(int id) {
		String sql = "DELETE FROM `Departments` WHERE department_id = ?";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setInt(1, id);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
 
}
