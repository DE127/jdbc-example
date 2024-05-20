package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Salary;

public class ImplSalaryDAO implements ISalaryDAO {

	private Connection mCnn;
	
	public ImplSalaryDAO() {
		mCnn = DatabaseHelper.getConnection();
	}
	
	@Override
	public List<Salary> getAllSalary() {
		String sql = "SELECT * FROM Salary";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			List<Salary> lst = new ArrayList<>();
			while (rs.next()) {
				int salary_id = rs.getInt("salary_id");
				int employee_id = rs.getInt("employee_id");
				Double salary_amount = rs.getDouble("salary_amount");
				String start_date  = rs.getString("start_date");

				Salary sItem = new Salary(salary_id, employee_id, salary_amount, start_date);
				lst.add(sItem);
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
	public Salary getSalaryId(int id) {
		String sql = "SELECT * FROM Salary WHERE salary_id = ?";
		ResultSet rs = null;
		try {
            PreparedStatement pst = mCnn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Salary salary = null;
            if (rs.next()) {
                int salary_id = rs.getInt("salary_id");
                int employee_id = rs.getInt("employee_id");
                Double salary_amount = rs.getDouble("salary_amount");
                String start_date = rs.getString("start_date");
                
                salary = new Salary(salary_id, employee_id, salary_amount, start_date);
                
            }
            return salary;
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
	public boolean addSalary(Salary salary) {
		String sql = "INSERT INTO Salary(employee_id, salary_amount, start_date) VALUES(?, ?, ?)";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setInt(1, salary.getEmployee_id());
			pstm.setDouble(2, salary.getSalary_amount());
			pstm.setString(3, salary.getStart_date());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSalary(Salary Salary) {
		String sql = "UPDATE Salary SET employee_id = ?, salary_amount = ?, start_date = ? WHERE salary_id = ?";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setInt(1, Salary.getEmployee_id());
			pstm.setDouble(2, Salary.getSalary_amount());
			pstm.setString(3, Salary.getStart_date());
			pstm.setInt(4, Salary.getSalary_id());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteSalary(int id) {
		String sql = "DELETE FROM Salary WHERE salary_id = ?";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setInt(1, id);
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
