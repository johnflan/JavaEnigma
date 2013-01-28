package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.Scrambler;
import com.johnflan.enigma.scrambler.ScramblerImpl;
import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.RotorType;


public class ScramblerTest {
	
	Scrambler scrambler;	
	private static final String plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Test
	public void fourRotorPlugboardTest(){
		fourRotorWithPlugboard();
		
		String cipherText = encode(plainText);
		
		fourRotorWithPlugboard();
		
		String derivedPlainText =  encode(cipherText);
		
		Assert.assertEquals(derivedPlainText, plainText);
		
	}
	
	@Test
	public void fourRotorTest(){
		fourRotor();
		
		String cipherText = encode(plainText);
		
		fourRotor();
		
		String derivedPlainText =  encode(cipherText);
		
		Assert.assertEquals(derivedPlainText, plainText);
		
	}
	
	
	@Test
	public void threeRotorPlugboardTest(){
		threeRotorWithPlugboard();
		
		String cipherText = encode(plainText);
		
		threeRotorWithPlugboard();
		
		String derivedPlainText =  encode(cipherText);
		
		Assert.assertEquals(derivedPlainText, plainText);
		
	}
	
	
	@Test
	public void threeRotorTest(){
		threeRotor();
		
		String cipherText = encode(plainText);
		
		threeRotor();
		
		String derivedPlainText =  encode(cipherText);
		
		Assert.assertEquals(derivedPlainText, plainText);
		
	}
	
	private String encode(String plainText){
		char[] pt = plainText.toCharArray();
		
		String output = "";
		
		for(int i = 0; i < pt.length; i++){
			output += scrambler.encode(pt[i]);
		}
		return output;
	}
	
	
	private void fourRotorWithPlugboard(){
		Plugboard plugboard = new PlugboardImpl();
		plugboard.addCable('C', 'Z').addCable('K', 'P').addCable('R', 'T');
		
		scrambler = new ScramblerImpl(
				RotorType.V,
				RotorType.II,
				RotorType.III,
				RotorType.IV,
				ReflectorType.C,
				plugboard);
	}
	
	private void fourRotor(){
		scrambler = new ScramblerImpl(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				RotorType.IV,
				ReflectorType.B);
	}
	
	private void threeRotorWithPlugboard(){
		Plugboard plugboard = new PlugboardImpl();
		plugboard.addCable('C', 'Z').addCable('K', 'P').addCable('R', 'T');
		
		scrambler = new ScramblerImpl(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				ReflectorType.C,
				plugboard);
	}
	
	private void threeRotor(){
		
		scrambler = new ScramblerImpl(
				RotorType.I,
				RotorType.II,
				RotorType.III,
				ReflectorType.C);
	}
}
