package pl.kukla.krzys.restaurant.dao.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.kukla.krzys.restaurant.dao.DrinkDao;
import pl.kukla.krzys.restaurant.model.Drink;

public class DrinkDaoImpl implements DrinkDao{
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	//of course these should be implemented in database,
			// but to simplify these have been implemented as hard coded
	List<Drink> list = Arrays.asList(
				new Drink(1L, "First drink", new BigDecimal("23.10"), new BigDecimal("0.5")),
				new Drink(2L, "Second drink", new BigDecimal("18.20"), new BigDecimal("0.7")),
				new Drink(3L, "Third drink", new BigDecimal("9.10"), new BigDecimal("1")),
				new Drink(4L, "Fourth drink", new BigDecimal("12.99"), new BigDecimal("0.2")),
				new Drink(5L, "Fifth drink", new BigDecimal("8.99"), new BigDecimal("0.33"))
			);

	public Set<Drink> getAll() {
		return new HashSet<Drink>(list);
	}

	public Drink getOne(long id) {
		for(Drink d: list){
			if (d.getId()==id) return d;
		}
		return null;
	}

	public Set<Drink> getByVolume(double volume) {
		if (volume<=0){
			log.error(volume);
			throw new IllegalArgumentException();
		}
		Set<Drink> set = new HashSet<Drink>();
		for(Drink d: list){
			if (d.getVolume().doubleValue()==volume) set.add(d);
		}
		return set;
	}

}
