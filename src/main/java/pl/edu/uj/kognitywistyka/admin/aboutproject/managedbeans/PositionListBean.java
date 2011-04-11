package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.PositionBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

@ManagedBean
@RequestScoped
public class PositionListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Dependency injection via Spring
	@ManagedProperty(name="positionBo", value="#{positionBo}")
	PositionBo positionBo;
	
	public void setPositionBo(PositionBo positionBo) {
		this.positionBo = positionBo;
	}
	
	public List<Position> getAllPositions() {
		return positionBo.findAllPositions();
	}
}
