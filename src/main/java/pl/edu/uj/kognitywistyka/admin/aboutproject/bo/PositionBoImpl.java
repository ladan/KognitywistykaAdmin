package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.PositionDao;

public class PositionBoImpl implements PositionBo, Serializable {

	PositionDao positionDao;
	
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}
}
