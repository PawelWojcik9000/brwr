package pl.browarmistrz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity(name = "Recipe")
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeId;
	@Column(length = 100, nullable = false)
	private String brewName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "malts_id")
	private List<Malt> malts = new ArrayList<Malt>();

	public Recipe() {

	}
	
	

	public Recipe(String brewName) {
		super();
		this.brewName = brewName;
	}



	public Recipe(String brewName, List<Malt> malts) {
		super();
		this.brewName = brewName;
		this.malts = malts;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getBrewName() {
		return brewName;
	}

	public void setBrewName(String brewName) {
		this.brewName = brewName;
	}

	
	public void addMalt(Malt malt) {
		malts.add(malt);
	}

	public List<Malt> getMalts() {
		return malts;
	}

	public void setMalts(List<Malt> malts) {
		this.malts = malts;
	}
	

}
