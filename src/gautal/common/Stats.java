package gautal.common;

import java.util.ArrayList;

public class Stats<T> {
	
	/**
	 * Best solution in the whole execution
	 */
	T OverallBest;
	/**
	 * a list of itmes that were considered the best in the respective iteration 
	 */
	ArrayList<T> bestPerIteration; //best per Iterration
	/**
	 * a list of items containing the standard deviation of items in each iteration
	 */
	ArrayList<Double> stdevPerIteration;  //mean per Iterration
	/**
	 * a list of items containing the mean of items in each iteration
	 */
	ArrayList<Double> meanPerIteration;  //standard deviation per Iterration
	
	
	public T getOverallBest() {
		return OverallBest;
	}
	public void setOverallBest(T overallBest) {
		OverallBest = overallBest;
	}
	public ArrayList<T> getBestPerIteration() {
		return bestPerIteration;
	}
	public void setBestPerIteration(ArrayList<T> bestPerIteration) {
		this.bestPerIteration = bestPerIteration;
	}
	public ArrayList<Double> getStdevPerIterration() {
		return stdevPerIteration;
	}
	public void setStdevPerIterration(ArrayList<Double> stdevPerIterration) {
		this.stdevPerIteration = stdevPerIterration;
	}
	public ArrayList<Double> getMeanPerIterration() {
		return meanPerIteration;
	}
	public void setMeanPerIterration(ArrayList<Double> meanPerIterration) {
		this.meanPerIteration = meanPerIterration;
	}



}
