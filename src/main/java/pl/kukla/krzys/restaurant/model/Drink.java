package pl.kukla.krzys.restaurant.model;

import java.math.BigDecimal;

/**
 * This class represents model Drink
 * 
 * @author Krzysztof
 *
 */
public class Drink extends AbstractItem{
	private BigDecimal volume;
	
	public Drink(long id, String name, BigDecimal price, BigDecimal volume) {
		super(id, name, price);
		this.volume = volume;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		Drink other = (Drink) obj;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+", Price: "+price+", Volume:"+volume;
	}
	
}	
