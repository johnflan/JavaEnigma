package com.johnflan.enigma;


public class EnigmaMachine {
	
	private Mechanism mechanism;
	
	EnigmaMachine() throws Exception{
		
		mechanism = new Mechanism(new Rotor(RotorType.I),
									new Rotor(RotorType.II),
									new Rotor(RotorType.III),
									null,
									new Reflector(ReflectorType.Umkehrwalze_B),
									null);

	}
	
	public String encryptString(String input) throws Exception{
		input.toUpperCase();
		char[] inputArray = input.toCharArray();
		String cipherText = "";
		
		for (int i = 0; i < inputArray.length ; i++){
			cipherText = cipherText + toCipherText(inputArray[i]);
		}
		return cipherText;
	}

	private char toCipherText(char pt) throws Exception{
		return mechanism.encode(pt);
	}

}
