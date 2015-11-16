package pl.kukla.krzys.restaurant.model;


/**
 * Abstract class for all models
 * 
 * @author Krzysztof
 *
 */
public class AbstractEntity {
	protected long id;
	
	public AbstractEntity(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
