package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "malts")
public class Malt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String maltName;
	private String maltWeight;
	
	@ManyToOne
	private Recipe recipe;

	public Malt() {

	}

	public int getId() {
		return id;
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
