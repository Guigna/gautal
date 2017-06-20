package gautal.ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generic implementation of a Genetic Algorithm.
 * @author Cesar A. Astudillo
 * @version 0.0.1
 * @param <T> the type of the individual
 */
public class GeneticAlgorithm <T> {
	//parameters
	protected int popsize;
	//double pmut;
	double pcross;
	int maxiter;
	//methods
	Crossover<T> crossover;
	protected Selection<T> selection;
	Mutation<T> mutation;
	protected Fitness<T> fitness;
	//Stats<T> stats;
	//population
	protected ArrayList<T> population=null;

	//the fitness probability of the population
	protected ArrayList<Double> probability;
	
	// selected individual from current generation
	ArrayList<Integer> matingPoolIndex;
	private Random r;
	
	//STATS
	public T OverallBest=null;
	public ArrayList<T> bestPerGeneration; //best per generation
	protected ArrayList<Double> stdevPerGeneration;  //mean per generation
	protected ArrayList<Double> meanPerGeneration;  //standard deviation per generation


	/**
	 * @param popsize The population size.
	 * @param pmut The probability of mutation.
	 * @param pcross The probability of crossover.
	 * @param maxiter The maximum number of iterations.
	 * @param crossover The crossover mechanism.
	 * @param selection The selection method.
	 * @param mutation The mutation method.
	 * @param fitness The fitness function.
	 */
	public GeneticAlgorithm(int popsize, double pcross,
			int maxiter, Crossover<T> crossover, Selection<T> selection,
			Mutation<T> mutation, Fitness<T> fitness, Random r) {
		super();
		this.popsize = popsize;
		//this.pmut = pmut;
		this.pcross = pcross;
		this.maxiter = maxiter;
		this.crossover = crossover;
		this.selection = selection;
		this.mutation = mutation;
		this.fitness = fitness;
		this.r=r;

		//stats stuff
		bestPerGeneration = new ArrayList<T>(); //best per generation
		stdevPerGeneration = new ArrayList<Double>();  //mean per generation
		meanPerGeneration = new ArrayList<Double>();  //standard deviation per generation
	}

	public void execute()
	{
		//TODO check parameters, like probability and population, to make everything interchangable
		
		evaluation();System.out.println("Evaluacion realizada");
		selection(); System.out.println("seleccion realizada");
		population=reproduction(); System.out.println("reproduccion realizada");
	}


	public ArrayList<T> reproduction() 
	{
		//the process of crossover and mutation follows the receipe of MATLAB's GA
		//http://www.mathworks.com/help/gads/how-the-genetic-algorithm-works.html#f13721
		//Produces children from the parents. Children are produced either by making random changes to a single parent�mutation�or by combining the vector entries of a pair of parents�crossover.

		//new (empty) population
		ArrayList<T> newPopulation=new ArrayList<T>();
		for (int i = 0; i < popsize; i=i+2) {
			System.out.println("reproduccion de "+ i);
			//crossover
			if (r.nextDouble()<pcross)
			{
				crossover.cross(population.get(matingPoolIndex.get(i)), population.get(matingPoolIndex.get(i+1)));
				newPopulation.add(crossover.getBrother());
				newPopulation.add(crossover.getSister());
			}
			else
			{
				//mutate333333333333333333
				T mut1=mutation.mutate(population.get(matingPoolIndex.get(i)));
				T mut2=mutation.mutate(population.get(matingPoolIndex.get(i+1)));
				//System.out.println(matingPoolIndex.get(i)+" "+matingPoolIndex.get(i+1));
				newPopulation.add(mut1);
				newPopulation.add(mut2);
			}
		}
	
		return newPopulation;
	}

	
	public void selection() 
	{
		matingPoolIndex=new ArrayList<Integer>();
		selection.buildSelectionModel(population, probability);
		int a,b;
		for (int i = 0; i < popsize/2; i++)
		{
			do{
				a=selection.select();
				b=selection.select();
			}while(a==b);
			//System.out.println(a+" "+b);
			matingPoolIndex.add(a);
			matingPoolIndex.add(b);
		}
		 //TODO check odd population in other parts of the code
		if(popsize%2==1)
			matingPoolIndex.add(selection.select());
	}

	public ArrayList<Double> evaluation() {
		T bestIndividualFromTheCurrentPopulation=null;
		double bestFitnessFromTheCurrentPopulation=Double.NEGATIVE_INFINITY;//max on this generation
		double totalSumOfFitness=0.0;
		probability=new ArrayList<Double>();
		
		
		for (int i = 0; i < popsize; i++) 
		{
			double f=fitness.evaluate(population.get(i));
			if (f>bestFitnessFromTheCurrentPopulation)
			{ //look for MAX fitness
				System.out.println("f "+ f + "best: " + bestFitnessFromTheCurrentPopulation );
				bestFitnessFromTheCurrentPopulation=f;
				bestIndividualFromTheCurrentPopulation=population.get(i);
			}
			
			totalSumOfFitness = totalSumOfFitness + f;
			probability.add(f);
		}

		//add the best individual to a history of best individual per generation
		bestPerGeneration.add(bestIndividualFromTheCurrentPopulation);
		
		//store mean of current population
		meanPerGeneration.add(totalSumOfFitness/population.size());
		
		//store standard deviation of current population
		double mean = totalSumOfFitness/population.size();
		double temp = 0.0;
		for(T individual : population)
			temp += (mean-fitness.evaluate(individual))*(mean-fitness.evaluate(individual));
		stdevPerGeneration.add(Math.sqrt(temp/population.size()));

		//check if the best individual of the current population is better than the overall winner
		if (OverallBest==null || bestFitnessFromTheCurrentPopulation<fitness.evaluate(OverallBest)){ // Seg�n yo deberia ser mayor
			OverallBest=bestIndividualFromTheCurrentPopulation;
		}
		
		//normalizing the fitness of the individuals, i.e., computing probability
		for (int i = 0; i < popsize; i++) 
		{
			probability.set(i,probability.get(i)/totalSumOfFitness);
			//System.out.println(individualToString(population.get(i))+" "+util.binaryToInteger(population.get(i))+" "+probability.get(i));
		}
		return probability;
	}


	public ArrayList<T> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<T> population) {
		this.population = population;
	}

}
