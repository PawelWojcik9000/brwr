package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity//(name = "Malt")
//@Table(name = "malts")
public class Malt {

	@Id
	@GeneratedValue
	private int id;
	private String maltName;
	private String maltWeight;
	@ManyToOne
	private Recipe recipe;
	
	public Malt() {
		
	}

	public Malt(String maltName, String maltWeight) {
		super();
		this.maltName = maltName;
		this.maltWeight = maltWeight;
	}

	public String getMaltName() {
		return maltName;
	}

	public void setMaltName(String maltName) {
		this.maltName = maltName;
	}

	public String getMaltWeight() {
		return maltWeight;
	}

	public void setMaltWeight(String maltWeight) {
		this.maltWeight = maltWeight;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	
}
