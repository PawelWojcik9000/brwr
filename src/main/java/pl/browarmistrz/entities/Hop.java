package pl.browarmistrz.entities;

public class Hop {

	private int hopId;
	private String hopName;
	private double hopWeight; 
	private double alphaAcids;
	private int hopYear;
	private int hopBoilTime;
	
	public Hop() {
		
	}
	
	public Hop(String hopName, double hopWeight, double alphaAcids, int hopYear, int hopBoilTime) {
		this.hopName = hopName;
		this.hopWeight = hopWeight;
		this.alphaAcids = alphaAcids;
		this.hopYear = hopYear;
		this.hopBoilTime = hopBoilTime;
	}

	public int getHopId() {
		return hopId;
	}

	public void setHopId(int hopId) {
		this.hopId = hopId;
	}

	public String getHopName() {
		return hopName;
	}

	public void setHopName(String hopName) {
		this.hopName = hopName;
	}
	
	public double getHopWeight() {
		return hopWeight;
	}

	public void setHopWeight(double hopWeight) {
		this.hopWeight = hopWeight;
	}

	public double getAlphaAcids() {
		return alphaAcids;
	}

	public void setAlphaAcids(double alphaAcids) {
		this.alphaAcids = alphaAcids;
	}

	public int getHopYear() {
		return hopYear;
	}

	public void setHopYear(int hopYear) {
		this.hopYear = hopYear;
	}

	public int getHopBoilTime() {
		return hopBoilTime;
	}

	public void setHopBoilTime(int hopBoilTime) {
		this.hopBoilTime = hopBoilTime;
	}
	

}
