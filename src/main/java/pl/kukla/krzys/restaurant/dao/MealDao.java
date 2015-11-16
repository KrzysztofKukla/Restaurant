package pl.kukla.krzys.restaurant.dao;

import java.util.Set;

import pl.kukla.krzys.restaurant.enums.Cuisine;
import pl.kukla.krzys.restaurant.enums.MealType;
import pl.kukla.krzys.restaurant.model.Meal;

/**
 * API for MealDao which extends GenericDao<T>
 * 
 * @author Krzysztof
 *
 */
public interface MealDao extends GenericDao<Meal>{
	/**
	 * This method gets Meal objects for passed cuisine type
	 * 
	 * @param cuisine
	 * @return set objects of Meal
	 */
	Set<Meal> getByCuisine(Cuisine cuisine);
	
	/**
	 * This method gets Meal objects for passed enum meal type
	 * 
	 * @param meal
	 * @return set objects of Meal
	 */
	Set<Meal> getByMealType(MealType meal);
	
	/**
	 * This method gets Meal objects for passed weight
	 * 
	 * @param weight
	 * @throws IllegalArgumentException if weight is less or equal to 0  
	 * @return set objects Meal
	 */
	Set<Meal> getByVolume(double weight);
}
