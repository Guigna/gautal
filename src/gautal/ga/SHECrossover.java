package gautal.ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Single point crossover implementation
 * @author Cesar Astudillo
 * @version 0.0.1
 *
 */
public class SHECrossover extends Crossover<List<Double>> {



	
	public SHECrossover(Random r) {
		super(r);
	}

	/**
	 * This implementation assumes that the length of both individuals are the same
	 */
	public void cross(List<Double> father, List<Double> mother) {
		int xpoint = r.nextInt(father.size());

		cross(father, mother, xpoint);
	}

	/**
	 * Single point crossover. assumes the length of both individuals are the same. sort
	 * 
	 * @param father first individual chosen for crossover
	 * @param mother second individual chose for reproduction
	 * @param xpoint the crossover point
	 */
	public void cross(List<Double> father, List<Double> mother,
			int xpoint) {
		brother=new ArrayList<Double>();
		sister=new ArrayList<Double>();
		
		for (int i = 0; i < xpoint; i++){
			brother.add(father.get(i));
			sister.add(mother.get(i));
		}
		for (int i = xpoint; i < father.size(); i++){
			brother.add(mother.get(i));
			sister.add(father.get(i));
		}
                
                Collections.sort(brother); // sorts the resultant vector to ensure constraints
                Collections.sort(sister);
	}

}
