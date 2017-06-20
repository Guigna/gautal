package gautal.ga;

import java.util.Random;

/**
 * @author César Astudillo
 * Apr 28, 2014
 * @param <T>
 */
public abstract class Mutation<T> {
	
	
	// TODO eliminate randomness form mutator operator. instead, the constructor receive item to be mutated and mutation position 
	public Mutation(Random r) {
		super();
		this.r = r;
	}

	protected Random r;
	
	/**
	 * Mutates an individual, returning a new object.
	 * @param individual The individual to be mutated. It is defined as final, to ensure the method does not modify the object. The method forces to create a deep copy of the item before mutating.
	 * @return The mutated individual.
	 */
	public abstract T mutate(final T individual);
}
