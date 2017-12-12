package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yeasts")
public class Yeast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String yeastName;
	private String yeastForm;
	private String yeastLab;
	private double yeastWeight;

	@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	public Yeast() {

	}

	public int getId() {
		return id;
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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	
}
