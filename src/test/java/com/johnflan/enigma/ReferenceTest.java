package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.Scrambler;
import com.johnflan.enigma.scrambler.ScramblerImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class ReferenceTest {
	
	private Scrambler scrambler;
	
	@BeforeMethod
	private void setSetup(){
		scrambler = new ScramblerImpl(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				ReflectorType.B,
				null);
	}
	
	@Test
	public void confirmedEnigmaExample(){
		//With the default enigma configuration above
		//ABCDEFG should encrypt to BJELRQZ
		String plainText = "ABCDEFG";
		String referenceCipherText = "BJELRQZ";
		String cipherText = "";
		
		for (char pt : plainText.toCharArray()){
			cipherText += scrambler.encode(pt);
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
			cipherText += scrambler.encode(pt);
		}
		
		System.out.println("Resulting cipherText: " + cipherText);
		Assert.assertEquals(cipherText, referenceCipherText);
	}
}
