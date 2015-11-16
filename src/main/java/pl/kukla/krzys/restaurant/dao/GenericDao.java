package pl.kukla.krzys.restaurant.dao;

import java.util.Set;

/**
 * Generic interface to all implementation dao
 * 
 * @author Krzysztof
 *
 * @param <T>
 */
public interface GenericDao<T> {
	/**
	 * This method returns all rows 
	 * 
	 * @return set of objects of generic type T
	 */
	Set<T> getAll();
	/**
	 * This method returns only one object from table
	 * 
	 * @param id which represents identificator of object
	 * @return Object of type T
	 */
	T getOne(long id);
}
