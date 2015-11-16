package pl.kukla.krzys.restaurant.dao;

import java.util.Set;

import pl.kukla.krzys.restaurant.model.Addition;

/**
 * API for AdditionDao which extends GenericDao<T>
 * 
 * @author Krzysztof
 *
 */
public interface AdditionDao extends GenericDao<Addition>{
	/**
	 * This method get only objects with passed date
	 * 
	 * @param date
	 * @return set of object' Addition
	 */
	Set<Addition> getByDateOfCreate(int expirationYear);
}
