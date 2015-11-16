package pl.kukla.krzys.restaurant.model;

import java.math.BigDecimal;

import pl.kukla.krzys.restaurant.enums.Cuisine;
import pl.kukla.krzys.restaurant.enums.MealType;

/**
 * Model represents Meal
 * 
 * @author Krzysztof
 *
 */
public class Meal extends AbstractItem {
	private BigDecimal weight;
	private Cuisine cuisine;
	private MealType mealType;
	
	public Meal(long id, String name, BigDecimal price, BigDecimal weight,
			Cuisine cuisine, MealType mealType) {
		super(id, name, price);
		this.weight = weight;
		this.cuisine = cuisine;
		this.mealType = mealType;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+", Price: "+price.doubleValue()+", Weight: "+weight;
	}
	
	
}
