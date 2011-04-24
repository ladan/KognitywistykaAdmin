package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;



public class PositionDaoImpl extends HibernateDaoSupport
	implements PositionDao{

	
	public void addPosition(Position position) {
		getHibernateTemplate().save(position);
		
	}

	@SuppressWarnings("unchecked")
	public List<Position> findAllPositions() {
		return getHibernateTemplate().find("from Position order by positionId asc");
	}

	@Override
	public void removePosition(Position position) {
		getHibernateTemplate().delete(position);
	}
	
	public Position getPosition(long id) {
		return (Position) getHibernateTemplate().get(Position.class, id);
	}
	
}