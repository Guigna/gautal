package gautal.ga;

import java.util.Random;

/**
 * @author César Astudillo
 * Apr 28, 2014
 * @param <T>
 */
public abstract class Crossover<T> {
	
	protected Random r;
	protected T brother=null;
	protected T sister=null;
	
	
	//TODO eliminate randomness form crossover, instead specify mutation point through construcot
	public Crossover(Random r) {
		super();
		this.r=r;
	}
	
	public abstract void cross(final T father, final T mother);

	public T getBrother() {
		return brother;
	}

	public T getSister() {
		return sister;
	}
}
