package com.johnflan.enigma;

public enum RotorType {
	
	I("EKMFLGDQVZNTOWYHXUSPAIBRCJ"),
	II("AJDKSIRUXBLHWTMCQGZNPYFVOE"),
	III("BDFHJLCPRTXVZNYEIWGAKMUSQO"),
	IV("ESOVPZJAYQUIRHXLNFTGKDCMWB"),
	V("VZBRGITYUPSDNHLXAWMJQOFECK"),
	VI("JPGVOUMFYQBENHZRDKASXLICTW"),
	VII("NZJHGRCXMYSWBOUFAIVLPEKQDT"),
	VIII("FKQHTLXOCBJSPDZRAMEWNIUYGV"),
	Beta("LEYJVCNIXWPBQMDRTAKZGFUHOS"),
	Gamma("FSOKANUERHMBTIYCWLQPZXVGJD");
	
	private char[] charMapping;
	
	RotorType(String charMapping){
		this.charMapping = charMapping.toCharArray();
	}
	
	public char[] getMapping(){
		return charMapping;
	}

}
