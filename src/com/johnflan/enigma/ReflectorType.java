package com.johnflan.enigma;

public enum ReflectorType {
	
	Umkehrwalze_B("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
	Umkehrwalze_C("FVPJIAOYEDRZXWGCTKUQSBNMHL");
	
	private char[] mapping;
	
	ReflectorType(String charMapping){
		mapping = charMapping.toCharArray();
	}
	
	public char[] getMapping(){
		return mapping;
	}
}
