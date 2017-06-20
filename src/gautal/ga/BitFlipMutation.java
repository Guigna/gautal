package gautal.ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * Randomly flips the value of one of the genes, assuming that the possible values are 0 or 1.
 * @author castudil
 * @date Apr 18, 2014
 */
public class BitFlipMutation extends Mutation<ArrayList<Integer>> {

	public BitFlipMutation(Random r) {
		super(r);
	}
	
	/**
	 * generic method for mutation. It receives the individual to be mutated and interan
	 * @param individual the individual to be mutated
	 */
	@Override
	public ArrayList<Integer> mutate(final ArrayList<Integer> individual) {
		int mutationPoint=r.nextInt(individual.size());
		return mutate(individual, mutationPoint);
	}


	/**
	 * This method allows the mutation of an individual by specifying a mutation point.
	 * @param individual
	 * @param mutationPoint
	 * @return
	 */
	public ArrayList<Integer> mutate(final ArrayList<Integer> individual,
			int mutationPoint) {
		//step 1: create a deep copy of individual
		ArrayList<Integer> mutatedIndividual= new  ArrayList<Integer>();
		for (Integer integer : individual) {
			mutatedIndividual.add(integer);
		}
		
		// step 2:perform mutation
		if (individual.get(mutationPoint)==1)
			individual.set(mutationPoint,0);
		else
			individual.set(mutationPoint,1);
		
		
		//step 3: return the mutated individual
		return mutatedIndividual;
	}

}
