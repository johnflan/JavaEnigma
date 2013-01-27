package com.johnflan.enigma.scrambler.reflector;

public enum ReflectorType {
		
	A("EJMZALYXVBWFCRQUONTSPIKHGD"),
	B("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
	C("FVPJIAOYEDRZXWGCTKUQSBNMHL"),
	
	//Naval Enigma used the following reflectors
	B_THIN("ENKQAUYWJICOPBLMDXZVFTHRGS"),
	C_THIN("RDOBJNTKVEHMLFCWZAXGYIPSUQ");
	
	private char[] mapping;
	
	ReflectorType(String charMapping){
		mapping = charMapping.toCharArray();
	}
	
	public char[] getMapping(){
		return mapping;
	}
}
