package pl.browarmistrz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additions")
public class Addition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String additionName;
	private String additionTime;
	private String additionUse;
	
	@ManyToOne
	private Recipe recipe;
	
	public Addition() {
		
	}

	public int getId() {
		return id;
	}

	public String getAdditionName() {
		return additionName;
	}

	public void setAdditionName(String additionName) {
		this.additionName = additionName;
	}

	public String getAdditionTime() {
		return additionTime;
	}

	public void setAdditionTime(String additionTime) {
		this.additionTime = additionTime;
	}

	public String getAdditionUse() {
		return additionUse;
	}

	public void setAdditionUse(String additionUse) {
		this.additionUse = additionUse;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	
}
