package gautal.ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author César Astudillo
 * Apr 28, 2014
 * @param <T>
 */
public abstract class Selection<T> {

	Random r;

	public Selection(Random r) {
		super();
		this.r=r;
	}
	
	public abstract void buildSelectionModel(final ArrayList<T> population, ArrayList<Double> probability);
	
	public abstract int select();
	
}
