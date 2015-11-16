package pl.kukla.krzys.restaurant.dao;

import java.util.Set;

import pl.kukla.krzys.restaurant.model.Drink;

/**
 * API for DrinkDao which extends GenericDao<T>
 * 
 * @author Krzysztof
 *
 */
public interface DrinkDao extends GenericDao<Drink> {
	/**
	 * This method gets Drink objects for passed volume
	 * 
	 * @param volume
	 * @throws IllegalArgumentException if volume is less or equal to 0
	 * @return set objects Drink
	 */
	Set<Drink> getByVolume(double volume);
}
