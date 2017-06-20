package gautal.ga;

/**
 * @author César Astudillo
 * Apr 28, 2014
 * @param <T>
 */
public abstract class Fitness<T> {
//	private boolean isAMinimizationProblem;
//	/**
//	 * 
//	 * @param isAMinimizationProblem whether the problem is minimization or maximization.
//	 */
//	public Fitness(boolean isAMinimizationProblem){
//		this.isAMinimizationProblem=isAMinimizationProblem;
//	}
	
	public abstract double evaluate(T individual);
	
	
}
