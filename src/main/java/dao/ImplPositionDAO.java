package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Position;

public class ImplPositionDAO implements IPositionDAO {
	private Connection mCnn;

	public ImplPositionDAO() {
		mCnn = DatabaseHelper.getConnection();
	}
	
	@Override
	public List<Position> select() {
		String sql = "SELECT * FROM `Positions`";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			List<Position> lst = new ArrayList<>();
			while (rs.next()) {
				int position_id = rs.getInt("position_id");
				String position_name = rs.getString("position_name");

				Position pItem = new Position(position_id, position_name);
				lst.add(pItem);
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
	public Position getDepartmentById(int id) {
		String sql = "SELECT * FROM `Positions` WHERE position_id = ?";
		ResultSet rs = null;
		try {
			Statement stt = mCnn.createStatement();
			rs = stt.executeQuery(sql);

			Position position = null;
			while (rs.next()) {
				int position_id = rs.getInt("position_id");
				String position_name = rs.getString("position_name");

				position = new Position(position_id, position_name);
			}
			return position;
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
	public boolean addPosition(Position position) {
		String sql = "INSERT INTO `Positions`(`position_name`) VALUES (?)";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, position.getPosition_name());
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePosition(Position position) {
		String sql = "UPDATE `Positions` SET `position_name` = ? WHERE `position_id` = ?";
		try {
			PreparedStatement ps = mCnn.prepareStatement(sql);
			ps.setString(1, position.getPosition_name());
			ps.setInt(2, position.getPosition_id());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePosition(int id) {
		String sql = "DELETE FROM `Positions` WHERE `position_id` = ?";
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
