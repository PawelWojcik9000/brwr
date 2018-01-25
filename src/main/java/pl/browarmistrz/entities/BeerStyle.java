package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beerstyles")
public class BeerStyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String styleName;
	private String OG;
	private String FG;
	private String ABV;
	private String IBU;
	private String SRM;
	
	public BeerStyle() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getOG() {
		return OG;
	}

	public void setOG(String oG) {
		OG = oG;
	}

	public String getFG() {
		return FG;
	}

	public void setFG(String fG) {
		FG = fG;
	}

	public String getABV() {
		return ABV;
	}

	public void setABV(String aBV) {
		ABV = aBV;
	}

	public String getIBU() {
		return IBU;
	}

	public void setIBU(String iBU) {
		IBU = iBU;
	}

	public String getSRM() {
		return SRM;
	}

	public void setSRM(String sRM) {
		SRM = sRM;
	}
	
	

}
