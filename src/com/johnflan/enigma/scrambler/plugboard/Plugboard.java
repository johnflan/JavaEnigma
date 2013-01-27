package com.johnflan.enigma.scrambler.plugboard;

public interface Plugboard {
	
	public Plugboard addCable(char a, char b);
	public char convert(char c);
}
