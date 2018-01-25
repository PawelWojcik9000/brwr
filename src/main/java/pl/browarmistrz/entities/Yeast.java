package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "yeasts")
public class Yeast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String yeastName;
	private String yeastForm;
	private String yeastLab;
	@Digits(integer=3, fraction=2)
	@Min(value=1)
	private Double yeastWeight;

	@OneToOne(mappedBy="yeast")
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

	public Double getYeastWeight() {
		return yeastWeight;
	}

	public void setYeastWeight(Double yeastWeight) {
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
