package com.johnflan.enigma.rotor;

public interface Rotor {
	
	public char in(char c);
	public char out(char c);
	public boolean inNotch();
	public void stepRotor();
}
