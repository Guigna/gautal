package gautal.common;


import java.util.ArrayList;
import java.util.Random;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import org.junit.Test;



public class StatsTest {

	double epsilon = 0.00001;
	
	@Test
	public void testOverallBest() {
		//fail("No ha sido implementado");
		Stats<Integer> stats;
		stats= new Stats<Integer>();
		int sol=20;
		assertNull(stats.getOverallBest());
		stats.setOverallBest(sol);
		assertNotNull(stats.getOverallBest());
		assertEquals((double)20,(double)stats.getOverallBest(),epsilon);
	}

	@Test
	public void testSetBestPerIteration() {
		Stats<Double> stats;
		stats= new Stats<Double>();
		ArrayList<Double> maxList;
		maxList = new ArrayList<Double>();
		Random r=new Random();
		int n=r.nextInt(10);
		for (int i = 0; i < n; i++) {
			maxList.add(r.nextDouble());
		}
		assertNull(stats.getBestPerIteration());
		stats.setBestPerIteration(maxList);
		assertNotNull(stats.getBestPerIteration());
		assertEquals((double)n, (double)stats.getBestPerIteration().size(), epsilon);
		
	}


}
