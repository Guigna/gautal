package gautal.ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quantum neighborhood works as follows: given an angles setting, it slightly
 * modifies a single angle by randomly adding or subtracting a small quantity,
 * specified by the a parameter called epsilon.
 *
 * @author César Astudillo <cesar dot astudillo at gmail dot com>
 * @date Apr 18, 2014
 */
public class SHEQuantumMutation extends Mutation< List<Double>> {

    private final double epsilon;

    public SHEQuantumMutation(Random r, double epsilon) {
        super(r);
        this.epsilon = epsilon;
    }

    /**
     * @param current A sequence of angles representing the current solution
     * @return A sequence of angles which are in the neighborhood of the current
     * solution.
     */
    @Override
    public List<Double> mutate(List<Double> individual) {
        //step 1: create a deep copy of individual
        List<Double> mutatedIndividual = new ArrayList<Double>();
        for (Double d : individual) {
            mutatedIndividual.add(d);
        }

        int index = r.nextInt(individual.size()); //select angle to be modified   
        int flipcoin = r.nextInt(2) * 2 - 1; //-1 or +1

        double value = mutatedIndividual.get(index) + flipcoin * epsilon;

        if (index == 0) {//first angle
            if (value > 0.0 && value < individual.get(index + 1)) //within range
            {
                mutatedIndividual.set(index, value);
            }
        } else if (index < individual.size() - 1) { //the general case
            if (value > individual.get(index - 1) && value < individual.get(index + 1)) //within range
            {
                mutatedIndividual.set(index, value);
            }
        } else {//last angle
            if (value < Math.PI / 2.0 && value > individual.get(index - 1)) //within range
            {
                mutatedIndividual.set(index, value);
            }
        }

        return mutatedIndividual;
    }

}
