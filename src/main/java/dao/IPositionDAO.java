package dao;

import java.util.List;

import entity.Position;

public interface IPositionDAO {
	public List<Position> select();

	Position getDepartmentById(int id);
	
	boolean addPosition(Position position);
	
	boolean updatePosition(Position position);
	
	boolean deletePosition(int id);
}
