package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

public interface PositionDao {
	void addPosition(Position position);

	List<Position> findAllPositions();
}
