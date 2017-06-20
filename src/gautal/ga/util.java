package gautal.ga;

import java.util.ArrayList;

/**
 * @author César Astudillo
 * Apr 28, 2014
 */
public class util {
	public static Integer binaryToInteger(ArrayList<Integer> individual){
	    Integer result = 0;
	    int pow=1;
	    for(int i=individual.size()-1;i>=0;i--){
	        	result+=pow*individual.get(i);
	        	pow=pow*2;
	    }
	    return result;
	}

	/**
	 * transform a binary chromosome into a string.
	 * @param individual the individual chromosome coded as a string of bits.
	 * @return a string representing the chromosome.
	 */
	public static String binaryToString(ArrayList<Integer> individual){
		StringBuilder result = new StringBuilder();
		
		for (Integer integer : individual) {
			result.append(integer);
		}
		return result.toString();
	}
}
