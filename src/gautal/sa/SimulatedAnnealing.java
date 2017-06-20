package gautal.sa;

import gautal.ls.CostFunction;
import gautal.ls.Neighborhood;
import gautal.ls.SolutionFactory;


public class SimulatedAnnealing<T> 
	{

	   public SimulatedAnnealing(Neighborhood<T> neighborhood, CostFunction<T> cost, SolutionFactory<T> solutionFactory,
			   ReductionTemperature reductionTemperature, int maxiter, Double t_final, Double t_inicial)
	    {
			super();
			this.neighborhood = neighborhood;
			this.cost = cost;
			this.solutionFactory = solutionFactory;
			this.maxiter = maxiter;
			this.t_final = t_final;
			this.t_inicial = t_inicial;
			this.reductionTemperature = reductionTemperature;
	    }


	protected Neighborhood<T> neighborhood;
	protected CostFunction<T> cost;
	protected SolutionFactory<T> solutionFactory;
	protected ReductionTemperature reductionTemperature;
	protected int maxiter;
	protected Double t_final;
	protected Double t_inicial;


	public T execute()
	{
		double t_actual = t_inicial;
		
		T x= solutionFactory.getSolution();
		Double cx=cost.evaluate(x);
		
		while (t_actual > t_final)
		{
			int i=0;
			
			while(i<maxiter)
			{
				T y = neighborhood.getNeighbor(x);
				Double cy= cost.evaluate(y);
				
				Double diferencia = cy-cx;
				
				if (cy<cx)
				{
					cx=cy;
					x=y;
				}
				else 
				{
					Double u = Math.random();
					
					if(u<Math.pow(Math.E,(-diferencia/t_actual)))
					{
						cx=cy;
						x=y;
					}
				}
				i++;	
			}
			
			t_actual = reductionTemperature.getNewTemperature(t_actual);
		}
		
		
	return x; 
	}

}