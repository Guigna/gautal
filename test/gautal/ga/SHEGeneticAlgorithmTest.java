/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gautal.ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author César Astudillo <cesar dot astudillo at gmail dot com>lo
 */
public class SHEGeneticAlgorithmTest {
    
    GeneticAlgorithm< List<Double> > ga;
    
    public SHEGeneticAlgorithmTest() {
        
        double epsilon=0.01;
        Random r=new Random();
        
        int popsize=50;
        double pcross=0.8;
        int maxiter=1000;
        Crossover< List<Double> > crossover=new SHECrossover(r);
        Selection<List<Double>> selection;
        Mutation<List<Double>> mutation = new SHEQuantumMutation(r, epsilon);
        Fitness<List<Double>> fitness;
        
        //GeneticAlgorithm(int popsize, double pcross,
//			int maxiter, Crossover<T> crossover, Selection<T> selection,
//			Mutation<T> mutation, Fitness<T> fitness, Random r) {
        ga = new GeneticAlgorithm<List<Double>>(popsize, pcross, maxiter, crossover,selection, mutation, fitness, r);
    }
    
   
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class GeneticAlgorithm.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GeneticAlgorithm instance = null;
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduction method, of class GeneticAlgorithm.
     */
    @Test
    public void testReproduction() {
        System.out.println("reproduction");
        GeneticAlgorithm instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.reproduction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selection method, of class GeneticAlgorithm.
     */
    @Test
    public void testSelection() {
        System.out.println("selection");
        GeneticAlgorithm instance = null;
        instance.selection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluation method, of class GeneticAlgorithm.
     */
    @Test
    public void testEvaluation() {
        System.out.println("evaluation");
        GeneticAlgorithm instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.evaluation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPopulation method, of class GeneticAlgorithm.
     */
    @Test
    public void testGetPopulation() {
        System.out.println("getPopulation");
        GeneticAlgorithm instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getPopulation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPopulation method, of class GeneticAlgorithm.
     */
    @Test
    public void testSetPopulation() {
        System.out.println("setPopulation");
        GeneticAlgorithm instance = null;
        instance.setPopulation(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
