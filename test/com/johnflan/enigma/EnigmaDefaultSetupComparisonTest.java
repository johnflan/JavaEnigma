package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;

public class EnigmaDefaultSetupComparisonTest {
	
	private Scrambler mechanism;
	
	@BeforeMethod
	private void setSetup(){
		try {
			mechanism = new Scrambler(
					RotorType.I,
					RotorType.II,
					RotorType.III,
					ReflectorType.Umkehrwalze_B,
					null);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=false)
	public void confirmedEnigmaExample(){
		String plainText = "ABCDEFG";
		String referenceCipherText = "BJELRQZ";
		String cipherText = "";
		
		for (char pt : plainText.toCharArray()){
			try {
				cipherText += mechanism.encode(pt);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			try {
				cipherText += mechanism.encode(pt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Resulting cipherText: " + cipherText);
		Assert.assertEquals(cipherText, referenceCipherText);
		
	}
}
