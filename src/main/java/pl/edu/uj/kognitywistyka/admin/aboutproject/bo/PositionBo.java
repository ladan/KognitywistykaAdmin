package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

public interface PositionBo {
	List<Position> findAllPositions();
	void addNewPosion(Position position);
	void removePosition(Position position);
}
