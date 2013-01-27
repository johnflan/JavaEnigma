package com.johnflan.enigma.reflector;

public enum ReflectorType {
	
	Umkehrwalze_B("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
	Umkehrwalze_C("FVPJIAOYEDRZXWGCTKUQSBNMHL"),
	
	//4 Rotor Naval Enigma used the following reflectors
	NavalUmkehrwalze_B("ENKQAUYWJICOPBLMDXZVFTHRGS"),
	NavalUmkehrwalze_C("RDOBJNTKVEHMLFCWZAXGYIPSUQ");
	
	private char[] mapping;
	
	ReflectorType(String charMapping){
		mapping = charMapping.toCharArray();
	}
	
	public char[] getMapping(){
		return mapping;
	}
}
