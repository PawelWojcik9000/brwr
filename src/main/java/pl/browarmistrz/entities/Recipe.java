package pl.browarmistrz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String brewName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private List<Malt> malts = new ArrayList<Malt>();

	private int mashTime;
	private int mashTemp;
	private int boilTime;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private List<Hop> hops = new ArrayList<Hop>();

	// NIE DZIALA FOREIGN KEY DLA DROZDZY
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
	@JoinColumn(name = "recipe_id")
	private Yeast yeast;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private List<Addition> additions = new ArrayList<Addition>();
	
	public Recipe() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrewName() {
		return brewName;
	}

	public void setBrewName(String brewName) {
		this.brewName = brewName;
	}

	public List<Malt> getMalts() {
		return malts;
	}

	public void setMalts(List<Malt> malts) {
		this.malts = malts;
	}

	public int getMashTime() {
		return mashTime;
	}

	public void setMashTime(int mashTime) {
		this.mashTime = mashTime;
	}

	public int getMashTemp() {
		return mashTemp;
	}

	public void setMashTemp(int mashTemp) {
		this.mashTemp = mashTemp;
	}

	public int getBoilTime() {
		return boilTime;
	}

	public void setBoilTime(int boilTime) {
		this.boilTime = boilTime;
	}

	public List<Hop> getHops() {
		return hops;
	}

	public void setHops(List<Hop> hops) {
		this.hops = hops;
	}

	public Yeast getYeast() {
		return yeast;
	}

	public void setYeast(Yeast yeast) {
		this.yeast = yeast;
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}

}
