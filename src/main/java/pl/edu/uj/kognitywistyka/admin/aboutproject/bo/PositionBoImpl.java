package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.PositionDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

public class PositionBoImpl implements PositionBo, Serializable {

	private static final long serialVersionUID = 1L;
	PositionDao positionDao;
	
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	public List<Position> findAllPositions() {
		return positionDao.findAllPositions();
	}

	public void addNewPosion(Position position) {
		positionDao.addPosition(position);
	}

	public void removePosition(Position position) {
		positionDao.removePosition(position);
	}
}
