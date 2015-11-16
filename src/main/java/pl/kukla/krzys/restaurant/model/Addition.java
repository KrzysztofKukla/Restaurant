package pl.kukla.krzys.restaurant.model;

import java.math.BigDecimal;

/**
 * This class represents a model Addition
 * 
 * @author Krzysztof
 *
 */
public class Addition extends AbstractItem{
	private int expirationYear;
	
	public Addition(long id, String name, BigDecimal price, int expirationYear) {
		super(id, name, price);
		this.expirationYear = expirationYear;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + expirationYear;
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
		Addition other = (Addition) obj;
		if (expirationYear != other.expirationYear)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+", Price: "+price+", Year of expiration:"+expirationYear;
	}
	
}
