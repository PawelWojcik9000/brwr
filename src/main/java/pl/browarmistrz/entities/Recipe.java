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
	// private int mashTime;
	// private int mashTemp;
	// private int boilTime;
	// private Yeast yeast;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "malts_id")
	private List<Malt> malts = new ArrayList<Malt>();
	// private List<Hop> hops = new ArrayList<Hop>();
	// private List<Addition> additions = new ArrayList<Addition>();
	// private int effervescentFermentation;
	// private int secondFermentation;

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

	// public Recipe(String brewName, int mashTime, int mashTemp, int boilTime,
	// Yeast yeast, List<Malt> malts,
	// List<Hop> hops, List<Addition> additions, int effervescentFermentation, int
	// secondFermentation) {
	// super();
	// this.brewName = brewName;
	// this.mashTime = mashTime;
	// this.mashTemp = mashTemp;
	// this.boilTime = boilTime;
	// this.yeast = yeast;
	// this.malts = malts;
	// this.hops = hops;
	// this.additions = additions;
	// this.effervescentFermentation = effervescentFermentation;
	// this.secondFermentation = secondFermentation;
	// }

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

	// public int getMashTime() {
	// return mashTime;
	// }
	//
	// public void setMashTime(int mashTime) {
	// this.mashTime = mashTime;
	// }
	//
	// public int getMashTemp() {
	// return mashTemp;
	// }
	//
	// public void setMashTemp(int mashTemp) {
	// this.mashTemp = mashTemp;
	// }
	//
	// public int getBoilTime() {
	// return boilTime;
	// }
	//
	// public void setBoilTime(int boilTime) {
	// this.boilTime = boilTime;
	// }
	//
	// public Yeast getYeast() {
	// return yeast;
	// }
	//
	// public void setYeast(Yeast yeast) {
	// this.yeast = yeast;
	// }
	//
	public void addMalt(Malt malt) {
		malts.add(malt);
	}

	public List<Malt> getMalts() {
		return malts;
	}

	public void setMalts(List<Malt> malts) {
		this.malts = malts;
	}
	//
	// public void addHop(Hop hop) {
	// hops.add(hop);
	// }
	//
	// public List<Hop> getHops() {
	// return hops;
	// }
	//
	// public void setHops(List<Hop> hops) {
	// this.hops = hops;
	// }
	//
	// public void addAddition(Addition addition) {
	// additions.add(addition);
	// }
	//
	// public List<Addition> getAdditions() {
	// return additions;
	// }
	//
	// public void setAdditions(List<Addition> additions) {
	// this.additions = additions;
	// }
	//
	// public int getEffervescentFermentation() {
	// return effervescentFermentation;
	// }
	//
	// public void setEffervescentFermentation(int effervescentFermentation) {
	// this.effervescentFermentation = effervescentFermentation;
	// }
	//
	// public int getSecondFermentation() {
	// return secondFermentation;
	// }
	//
	// public void setSecondFermentation(int secondFermentation) {
	// this.secondFermentation = secondFermentation;
	// }

}
