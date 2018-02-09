package pl.browarmistrz.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	private Calendar added;
	private Calendar brewed;
	
	private boolean publicRecipe;
	private boolean brewedRecipe = false;

	@NotBlank
	private String brewName;

	@Digits(integer=3, fraction=0)
	@Min(value=1)
	@NotNull
	private Integer mashTime;
	@Digits(integer=3, fraction=0)
	@Min(value=1)
	@NotNull
	private Integer mashTemp;
	@Digits(integer=3, fraction=0)
	@Min(value=1)
	@NotNull
	private Integer boilTime;
	@Digits(integer=3, fraction=2)
	@Min(value=1)
	@NotNull
	private Double brewSize;
	@OneToOne
	private BeerStyle beerStyle;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	@Valid
	private List<Malt> malts = new ArrayList<Malt>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	@Valid
	private List<Hop> hops = new ArrayList<Hop>();

	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Yeast yeast;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private List<Addition> additions = new ArrayList<Addition>();
	
	public Recipe() {

	}
	
	public double countWaterAmount() {
		double waterAmount = 0;
		for(Malt malt : malts) {
			waterAmount += malt.getMaltWeight();
		}
		return waterAmount*3;
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

	public Integer getMashTime() {
		return mashTime;
	}

	public void setMashTime(Integer mashTime) {
		this.mashTime = mashTime;
	}

	public Integer getMashTemp() {
		return mashTemp;
	}

	public void setMashTemp(Integer mashTemp) {
		this.mashTemp = mashTemp;
	}

	public Integer getBoilTime() {
		return boilTime;
	}

	public void setBoilTime(Integer boilTime) {
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

	public boolean isPublicRecipe() {
		return publicRecipe;
	}

	public boolean isBrewedRecipe() {
		return brewedRecipe;
	}

	public void setBrewedRecipe(boolean brewedRecipe) {
		this.brewedRecipe = brewedRecipe;
	}

	public void setPublicRecipe(boolean publicRecipe) {
		this.publicRecipe = publicRecipe;
	}

	public Double getBrewSize() {
		return brewSize;
	}

	public void setBrewSize(Double brewSize) {
		this.brewSize = brewSize;
	}

	public BeerStyle getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(BeerStyle beerStyle) {
		this.beerStyle = beerStyle;
	}

	public Calendar getAdded() {
		return added;
	}

	public void setAdded(Calendar added) {
		this.added = added;
	}

	public Calendar getBrewed() {
		return brewed;
	}

	public void setBrewed(Calendar brewed) {
		this.brewed = brewed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
