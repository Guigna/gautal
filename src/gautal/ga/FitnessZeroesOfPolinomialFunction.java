package gautal.ga;

import java.util.ArrayList;


/**
 * @author César Astudillo
 * Apr 28, 2014
 */
public class FitnessZeroesOfPolinomialFunction extends Fitness<ArrayList<Integer>> {

//	public FitnessZeroesOfPolinomialFunction() {
//		super(true);//minimization problem
//	}

	@Override
	public double evaluate(ArrayList<Integer> individual) {
		//f(x)=3x^2-3x+1
		
		
		//assertions are activated through the -ea option
		//see details in http://stackoverflow.com/questions/2758224/assertion-in-java
		//for eclipse, 
		//1) go to run-> run configurations -> arguments
		//2) put -ea in the "vm arguments"
		assert(individual!=null);
		assert(0<individual.size());
		
		
		double val= util.binaryToInteger(individual);
		int min=-10;
		int max=10;
		double x= min+(max-min) * val/ Math.pow(2, individual.size()); 
		//double f=x*x*x-3*x+2;
		double f=x*x-1;
		double theCurrentFitness=1/(1+Math.pow(Math.E, f));
		//System.out.println(util.binaryToString(individual)+" "+x+" -> "+theCurrentFitness);
		return theCurrentFitness;
		//return x;
	}

	

	
}
