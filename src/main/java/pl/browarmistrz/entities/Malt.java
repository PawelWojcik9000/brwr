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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "malts")
public class Malt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String maltName;
	@Digits(integer=3, fraction=2)
	@Min(value=0)
	@NotNull
	private Double maltWeight;
	
	@ManyToOne
	private Recipe recipe;

	public Malt() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaltName() {
		return maltName;
	}

	public void setMaltName(String maltName) {
		this.maltName = maltName;
	}

	public Double getMaltWeight() {
		return maltWeight;
	}

	public void setMaltWeight(Double maltWeight) {
		this.maltWeight = maltWeight;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
