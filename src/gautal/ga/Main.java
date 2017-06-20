package gautal.ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author César Astudillo
 * Apr 28, 2014
 */
public class Main {

	
	static Random r;
	
	public static void main(String[] args) {

		if(args.length == 0){
			System.err.println("Options: <popsize> <pcross> <maxiter> <seed>");
			System.err.println();
			System.err.println("where,");
			System.err.println("popsize: population size of the GA.");
			System.err.println("pcross: probability of crossover.");
			System.err.println("maxiter: Maximum number of iterations.");
			System.err.println("seed: seed for the pseudo-random initialization.");
			System.exit(1);
		}
		int c=-1;
		int popsize=Integer.parseInt(args[++c]);
		//double pmut=Double.parseDouble(args[++c]);
		double pcross=Double.parseDouble(args[++c]);
		int maxiter=Integer.parseInt(args[++c]);
		int seed=Integer.parseInt(args[++c]);
		
		 r=new Random(seed);
		
		Crossover<ArrayList<Integer>> crossover = new SinglePointCrossover(r);
		Selection<ArrayList<Integer>> selection = new RoulletteWheelSelection<ArrayList<Integer>>(r);
		Mutation<ArrayList<Integer>> mutation = new BitFlipMutation(r);
		Fitness<ArrayList<Integer>> fitness= new FitnessZeroesOfPolinomialFunction();

		GeneticAlgorithm<ArrayList<Integer>> ga;
		//init ga
		ga= new GeneticAlgorithm<ArrayList<Integer>>(popsize, pcross, maxiter, crossover, selection, mutation, fitness, r);
		
		//initial pop;
		ArrayList< ArrayList<Integer>> population=new  ArrayList< ArrayList<Integer>>();;
		for (int i = 0; i < popsize; i++) {
			population.add(initIndividual());
			//System.out.println(individualToString(population.get(i)));
		}
		
		ga.setPopulation(population);
		for (int i = 0; i < maxiter; i++) {
			ga.execute();
			//System.out.println(fitness.evaluate(ga.OverallBest));
			//System.out.println(fitness.evaluate(ga.bestPerGeneration.get(ga.bestPerGeneration.size()-1)));
		}
		
		//System.out.println(fitness.evaluate(ga.OverallBest));
		System.out.println("best solucion found");
		System.out.println("-------------------");
		System.out.println("Chormosome: "+ga.OverallBest);
		System.out.println("fitness: "+fitness.evaluate(ga.OverallBest));
		
		int min=-10;
		int max=10;
		double x= min+(max-min) * util.binaryToInteger(ga.OverallBest)/ Math.pow(2, ga.OverallBest.size()); 
		System.out.println("value for x: "+x);
	}
	
	public static ArrayList<Integer> initIndividual(){
		ArrayList<Integer> individual;
		individual= new ArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			individual.add(r.nextInt(2));
		}
		return individual;
	}
	
}


