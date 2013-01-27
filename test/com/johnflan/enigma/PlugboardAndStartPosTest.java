package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class PlugboardAndStartPosTest {
	
	private EnigmaMachine enigmaMachine;

	@Test
	public void test(){

		resetMachine();
		
		String output = enigmaMachine.encrypt("Hello  world!");
		
		resetMachine();
		
		String derivedPT = enigmaMachine.encrypt(output);
		
		Assert.assertEquals(derivedPT, "HELLOWORLD");
	}
	
	private void resetMachine(){
		
		Plugboard plugboard = new PlugboardImpl();
		plugboard.addCable('A', 'H').addCable('Q', 'C').addCable('P', 'Z');
		
		enigmaMachine = EnigmaMachineBuilder
				.addRotor1(RotorType.I, 'H')
				.addRotor2(RotorType.II, 'A')
				.addRotor3(RotorType.III, 'A')
				.addReflector(ReflectorType.B)
				.addPlugBoard(plugboard)
				.build();
		
	}
}
