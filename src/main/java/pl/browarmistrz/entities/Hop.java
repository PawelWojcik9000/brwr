package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hops")
public class Hop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hopName;
	@Digits(integer=3, fraction=0)
	@Min(value=1)
	private Integer hopWeight;
	@Digits(integer=3, fraction=0)
	@Min(value=1)
	private Integer hopBoilTime;

	@ManyToOne
	private Recipe recipe;

	public Hop() {

	}

	public String getHopName() {
		return hopName;
	}

	public void setHopName(String hopName) {
		this.hopName = hopName;
	}

	public Integer getHopWeight() {
		return hopWeight;
	}

	public void setHopWeight(Integer hopWeight) {
		this.hopWeight = hopWeight;
	}

	public Integer getHopBoilTime() {
		return hopBoilTime;
	}

	public void setHopBoilTime(Integer hopBoilTime) {
		this.hopBoilTime = hopBoilTime;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getId() {
		return id;
	}
	
}
