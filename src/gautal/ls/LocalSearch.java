package gautal.ls;



/**
 * Generic implementation for the Local Search algorithm.
 * @author César Astudillo
 * Apr 28, 2014
 * @param <T> the type of a candidate solution.
 */
public class LocalSearch<T> {

	public LocalSearch(Neighborhood<T> neighborhood, CostFunction<T> cost,
			SolutionFactory<T> solutionFactory, int maxiter) {
		super();
		this.neighborhood = neighborhood;
		this.cost = cost;
		this.solutionFactory = solutionFactory;
		this.maxiter = maxiter;
	}


	protected Neighborhood<T> neighborhood;
	protected CostFunction<T> cost;
	protected SolutionFactory<T> solutionFactory;
	protected int maxiter;


	public T execute(){

	T x= solutionFactory.getSolution();
	double cx=cost.evaluate(x);

	int i=0;
	while(i<maxiter)
	{
		T y = neighborhood.getNeighbor(x);
		double cy= cost.evaluate(y);
		if (cy<cx){
			cx=cy;
			x=y;
		}
		i++;
	}
	return x; 
	}

}
