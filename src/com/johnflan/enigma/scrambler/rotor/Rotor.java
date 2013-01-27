package com.johnflan.enigma.scrambler.rotor;

public interface Rotor {
	
	public char in(char c);
	public char out(char c);
	public boolean inNotch();
	public void stepRotor();
}
