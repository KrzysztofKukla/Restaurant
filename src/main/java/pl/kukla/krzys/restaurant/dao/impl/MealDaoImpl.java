package pl.kukla.krzys.restaurant.dao.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.kukla.krzys.restaurant.dao.MealDao;
import pl.kukla.krzys.restaurant.enums.Cuisine;
import pl.kukla.krzys.restaurant.enums.MealType;
import pl.kukla.krzys.restaurant.model.Meal;

/**
 * This class is implementation of DrinkDao API
 * 
 * @author Krzysztof
 *
 */
public class MealDaoImpl implements MealDao{
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	//of course these should be implemented in database,
		// but to simplify these have been implemented as hard coded
	List<Meal> list = Arrays.asList(
			new Meal(1L, "First meal", new BigDecimal("12.99"), new BigDecimal("2.50"),
					Cuisine.MEXICAN, MealType.DESSERT),
			new Meal(2L, "Second meal", new BigDecimal("2.99"), new BigDecimal("2.50"),
					Cuisine.POLISH, MealType.MAIL_COURSE),
			new Meal(3L, "Third meal", new BigDecimal("16.99"), new BigDecimal("2.50"),
					Cuisine.ITALIAN, MealType.MAIL_COURSE),
			new Meal(4L, "Fourth meal", new BigDecimal("32.99"), new BigDecimal("2.50"),
					Cuisine.MEXICAN, MealType.MAIL_COURSE),
			new Meal(5L, "Fifth meal", new BigDecimal("7.99"), new BigDecimal("2.50"),
					Cuisine.POLISH, MealType.DESSERT),
			new Meal(6L, "Sixth meal", new BigDecimal("16.99"), new BigDecimal("2.50"),
					Cuisine.POLISH, MealType.MAIL_COURSE)
			);

	public Set<Meal> getAll() {
		return new HashSet<Meal>(list);
	}

	public Meal getOne(long id) {
		for(Meal m: list){
			if (m.getId()==1) return m;
		}
		return null;
	}

	public Set<Meal> getByCuisine(Cuisine cuisine) {
		Set<Meal> set = new HashSet<Meal>();
		for (Meal m: list){
			if (m.getCuisine()==cuisine) set.add(m);
		}
		return set;
	}

	public Set<Meal> getByMealType(MealType meal) {
		Set<Meal> set = new HashSet<Meal>();
		for(Meal m: list){
			if (m.getMealType()== meal) set.add(m);
		}
		return set;
	}

	public Set<Meal> getByVolume(double weight) {
		if (weight<=0){
			log.error(weight);
			throw new IllegalArgumentException();
		}
		Set<Meal> set = new HashSet<Meal>();
		for(Meal m: list){
			if (m.getWeight().doubleValue()==weight) set.add(m);
		}
		return set;
	}
	

}
