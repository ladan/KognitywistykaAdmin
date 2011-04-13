package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.PositionBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

@ManagedBean
@RequestScoped
public class PositionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	
	@ManagedProperty(name="positionBo", value="#{positionBo}")
	PositionBo positionBo;
	@ManagedProperty(name="positionBunchBean", value="#{positionBunchBean}")
	PositionBunchBean positionBunchBean;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPositionBo(PositionBo positionBo) {
		this.positionBo = positionBo;
	}
	
	public void setPositionBunchBean(PositionBunchBean positionBunchBean) {
		this.positionBunchBean = positionBunchBean;
	}
	
	public String addPosition() {
		Position position = new Position();
		position.setName(name);
		
		positionBo.addNewPosion(position);

		resetData();
		return "";
	}
	
	public String removePosition(long positionId) {
		for (Position position : positionBunchBean.getAllPositions()) {
			if(position.getPositionId() == positionId)
				positionBo.removePosition(position);
		}
		resetData();
		return "";
	}
	
	private void resetData() {
		positionBunchBean.setAllPositions(null);
		setName("");
	}
	
}
