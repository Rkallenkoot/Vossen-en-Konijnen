package nl.hanze.leertaak2.tests;

import nl.hanze.leertaak2.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class SimulatieTest {
	
	// we hebben animals nodig
	// een field waar de animals in kunnen
	// een simulator view waar we het in laten zien???
	
	private Simulator sim;
	private static final int SIZE = 30;
	private static final int STEPS = 37;
	
	@Before
	public void setUp() throws Exception {
		sim = new Simulator(SIZE,SIZE);
	}

	@Test
	public void test_simulateOneStep() {
		sim.simulateOneStep();
	}
	
	@Test
	public void test_runLongSimulation(){
		sim.runLongSimulation();
	}
	
	@Test
	public void test_simulateMultipleSteps(){
		sim.simulate(STEPS);
	}

}
