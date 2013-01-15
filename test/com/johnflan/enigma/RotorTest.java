package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotorTest {
	
	private Rotor rotor;

	private final static char A = 'A';
	
	@Test
	public void testRotor1InAndOut() throws Exception{
		rotor = new Rotor(RotorType.I);
		
	
		Assert.assertEquals(rotor.in(A), 'E');
		
		
		Assert.assertEquals(rotor.out( rotor.in(A) ), 'A');
	}

}
