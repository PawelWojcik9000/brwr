package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hops")
public class Hop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hopName;
	private String hopWeight;
	private String alphaAcids;
	private String hopYear;
	private String hopBoilTime;

	@ManyToOne
	private Recipe recipe;

	public Hop() {

	}
	
	public int getId() {
		return id;
	}

	public String getHopName() {
		return hopName;
	}

	public void setHopName(String hopName) {
		this.hopName = hopName;
	}

	public String getHopWeight() {
		return hopWeight;
	}

	public void setHopWeight(String hopWeight) {
		this.hopWeight = hopWeight;
	}

	public String getAlphaAcids() {
		return alphaAcids;
	}

	public void setAlphaAcids(String alphaAcids) {
		this.alphaAcids = alphaAcids;
	}

	public String getHopYear() {
		return hopYear;
	}

	public void setHopYear(String hopYear) {
		this.hopYear = hopYear;
	}

	public String getHopBoilTime() {
		return hopBoilTime;
	}

	public void setHopBoilTime(String hopBoilTime) {
		this.hopBoilTime = hopBoilTime;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}
