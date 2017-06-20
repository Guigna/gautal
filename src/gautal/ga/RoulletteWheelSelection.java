package gautal.ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * Implementation of the Roullette Wheel Selection.
 * @author C�sar Astudillo
 * @version 0.0.1
 *
 * @param <T> the type of the individual
 */
public class RoulletteWheelSelection<T> extends Selection<T> {

	/**
	 * Accumulated probability
	 */
	double accum[];
	
	public RoulletteWheelSelection(Random r) {
		super(r);
	}


	
	@Override
	/**
	 * Computes the cumulative probabilities distribution for each individual of the population according to their normalized fitness. Must be called before selct()
	 */
	public void buildSelectionModel(ArrayList<T> population, ArrayList<Double> probability) 
	{
		accum= new double[population.size()];
		
		//build accumulated distribution array
		
		accum[0]=probability.get(0);
		
		for (int i = 1; i < probability.size(); i++) 
		{
			accum[i]=accum[i-1]+probability.get(i);
		}
	}

	@Override
/**
 * Roullette wheel selection. the method returns the index of an individual stochastically based on their normalized fitness.
 */
	public int select() 
	{
		double x=r.nextDouble();
		return select(x);
	}


	/**
	 * Roullette wheel selection. the method returns the index of an individual stochastically based on their normalized fitness.
	 * @param x the probability value
	 * @return the index of the selected individual 
	 */
	protected int select(double x) 
	{
		for (int i = 1; i < accum.length; i++)
			if (x<accum[i])
			{
				return i;
			}
		
		return accum.length-1;
	}

}
