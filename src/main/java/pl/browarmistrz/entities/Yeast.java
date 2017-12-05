package pl.browarmistrz.entities;

public class Yeast {

	private int yeastId;
	private String yeastName;
	private double yeastWeight;
	private String yeastForm;
	private String yeastLab;
	
	public Yeast() {
		
	}

	public Yeast(String yeastName, double yeastWeight, String yeastForm, String yeastLab) {
		super();
		this.yeastName = yeastName;
		this.yeastWeight = yeastWeight;
		this.yeastForm = yeastForm;
		this.yeastLab = yeastLab;
	}

	public int getYeastId() {
		return yeastId;
	}

	public void setYeastId(int yeastId) {
		this.yeastId = yeastId;
	}

	public String getYeastName() {
		return yeastName;
	}

	public void setYeastName(String yeastName) {
		this.yeastName = yeastName;
	}
	
	public double getYeastWeight() {
		return yeastWeight;
	}

	public void setYeastWeight(double yeastWeight) {
		this.yeastWeight = yeastWeight;
	}

	public String getYeastForm() {
		return yeastForm;
	}

	public void setYeastForm(String yeastForm) {
		this.yeastForm = yeastForm;
	}

	public String getYeastLab() {
		return yeastLab;
	}

	public void setYeastLab(String yeastLab) {
		this.yeastLab = yeastLab;
	}
	

}
