package com.johnflan.enigma;

import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;
import com.johnflan.enigma.scrambler.Scrambler;


public class EnigmaMachineImpl implements EnigmaMachine{
	
	private Scrambler scrambler;
	
	public EnigmaMachineImpl(Scrambler mechanism) {
		this.scrambler = mechanism;
	}
	
	public EnigmaMachineImpl() {
		scrambler = new Scrambler(	
				RotorType.I,
				RotorType.II,
				RotorType.III,
				ReflectorType.Umkehrwalze_B);
	}
	
	
	public String encrypt(String plainText){
		
		//Validate input string -- chars a-z, no spaces, punct
		
		plainText.toUpperCase();
		char[] inputArray = plainText.toCharArray();
		String cipherText = "";
		
		for (int i = 0; i < inputArray.length ; i++){
			cipherText = cipherText + encrypt(inputArray[i]);
		}
		return cipherText;
	}

	public char encrypt(char pt){
		return scrambler.encode(pt);
	}

}
