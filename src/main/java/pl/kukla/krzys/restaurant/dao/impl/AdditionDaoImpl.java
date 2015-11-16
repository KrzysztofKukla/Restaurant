package pl.kukla.krzys.restaurant.dao.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.kukla.krzys.restaurant.dao.AdditionDao;
import pl.kukla.krzys.restaurant.model.Addition;

/**
 * This class is implementation of AdditionDao interface
 * 
 * @author Krzysztof
 *
 */
public class AdditionDaoImpl implements AdditionDao{
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	//of course these should be implemented in database,
			// but to simplify these have been implemented as hard coded
	List<Addition> list = Arrays.asList(
				new Addition(1L, "First addition", new BigDecimal("2.99"), 2017),
				new Addition(2L, "Second addition", new BigDecimal("3.99"), 2016),
				new Addition(3L, "Third addition", new BigDecimal("1.99"), 2018),
				new Addition(4L, "Fourth addition", new BigDecimal("7.99"), 2015),
				new Addition(5L, "Fifth addition", new BigDecimal("5.99"), 2016)
			);

	public Set<Addition> getAll() {
		return new HashSet<Addition>(list);
	}

	public Addition getOne(long id) {
		for(Addition a: list){
			if (a.getId()==id) return a;
		}
		return null;
	}

	public Set<Addition> getByDateOfCreate(int year) {
		Set<Addition> set = new HashSet<Addition>();
		for(Addition a: list){
			if (a.getExpirationYear()==year) set.add(a);
		}
		return set;
	}
}
