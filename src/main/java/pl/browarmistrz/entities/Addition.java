package pl.browarmistrz.entities;

public class Addition {

	private int additionId;
	private String additionName;
	private String additionAffectTime;
	
	public Addition() {
		
	}

	public Addition(String additionName, String additionAffectTime) {
		this.additionName = additionName;
		this.additionAffectTime = additionAffectTime;
	}

	public String getAdditionName() {
		return additionName;
	}

	public void setAdditionName(String additionName) {
		this.additionName = additionName;
	}

	public String getAdditionAffectTime() {
		return additionAffectTime;
	}

	public void setAdditionAffectTime(String additionAffectTime) {
		this.additionAffectTime = additionAffectTime;
	}

	public int getAdditionId() {
		return additionId;
	}

	public void setAdditionId(int additionId) {
		this.additionId = additionId;
	}
	
	

}
