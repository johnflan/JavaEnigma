package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class ReferenceTest {
	
	private EnigmaMachine enigmaMachine;
	
	@BeforeMethod
	private void setSetup(){
		
		enigmaMachine = EnigmaMachineBuilder
						.addRotor1(RotorType.I)
						.addRotor2(RotorType.II)
						.addRotor3(RotorType.III)
						.addReflector(ReflectorType.B)
						.build();
		
	}
	
	@Test
	public void confirmedEnigmaExample(){
		//With the default enigma configuration above
		//ABCDEFG should encrypt to BJELRQZ
		String plainText = "ABCDEFG";
		String referenceCipherText = "BJELRQZ";
		String cipherText = "";
		
		for (char pt : plainText.toCharArray()){
			cipherText += enigmaMachine.encrypt(pt);
		}
		
		System.out.println("Resulting cipherText: " + cipherText);
		Assert.assertEquals(cipherText, referenceCipherText);
	}
	
	@Test
	public void confirmedEnigmaExampleReversed(){
		String plainText = "BJELRQZ";
		String referenceCipherText = "ABCDEFG";
		String cipherText = "";
		
		for (char pt : plainText.toCharArray()){
			cipherText += enigmaMachine.encrypt(pt);
		}
		
		System.out.println("Resulting cipherText: " + cipherText);
		Assert.assertEquals(cipherText, referenceCipherText);
	}
}
