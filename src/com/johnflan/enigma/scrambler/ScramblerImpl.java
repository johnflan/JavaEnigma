package com.johnflan.enigma.scrambler;

import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;
import com.johnflan.enigma.scrambler.reflector.Reflector;
import com.johnflan.enigma.scrambler.reflector.ReflectorImpl;
import com.johnflan.enigma.scrambler.reflector.ReflectorType;
import com.johnflan.enigma.scrambler.rotor.Rotor;
import com.johnflan.enigma.scrambler.rotor.RotorImpl;
import com.johnflan.enigma.scrambler.rotor.RotorType;

public class ScramblerImpl implements Scrambler{
	
	private Rotor[] rotors = new Rotor[4];
	private Reflector reflector;
	private Plugboard plugBoard;

	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector) {
		configure(rotor1, rotor2, rotor3, null, reflector, null);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector) {
		configure(rotor1, rotor2, rotor3, rotor4, reflector, null);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector, Plugboard plugBoard) {
		configure(rotor1, rotor2, rotor3, null, reflector, plugBoard);
	}
	
	public ScramblerImpl(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector, Plugboard plugBoard) {
		configure(rotor1, rotor2, rotor3, rotor4, reflector, plugBoard);
	}
	
	private void configure(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflectorType, Plugboard plugBoard){

		rotors[0] = new RotorImpl(rotor1);
		rotors[1] = new RotorImpl(rotor2);
		rotors[2] = new RotorImpl(rotor3);

		if (rotor4 != null){
			rotors[3] = new RotorImpl(rotor4);
		}
		
		reflector = new ReflectorImpl(reflectorType);
		
		this.plugBoard = plugBoard;
		
		if (plugBoard == null){
			this.plugBoard = new PlugboardImpl();
		}
	}
	
	public char encode(char pt) {
		return scramble(pt);
	}
	
	/**
	 * Encodes a character using rotor's, plugboard and reflector
	 * 
	 * This method implements the main mechanism of the Enigma Machine.
	 * For each character, the rotor's are stepped, the character is passed
	 * through the plugboard with any connected cables.
	 * 
	 * Initially, the rotor's of the machine is called in reverse numerical order,
	 * passing the electrical signal right to left. After passing the char from
	 * right to left through the rotor's the reflector is called. After reflection
	 * we pass the char again through the rotor's in numerical order to represent
	 * moving from left to right through the rotor's and back through the plugboard.
	 * 
	 * @param p (plaintext)
	 * @return char (ciphertext)
	 */
	private char scramble(char p){
		
		stepRotors();
		
		char c = plugBoard.convert(p);
		
		for(int i = 3; i >= 0; i--){
			if (rotors[i] == null)
				continue;
			c = rotors[i].in(c);
		}
		
		c = reflector.reflect(c);
		
		for(int i = 0; i < rotors.length; i++){
			if (rotors[i] == null)
				continue;
			c = rotors[i].out(c);
		}
		
		c = plugBoard.convert(c);
		
		return c;
	}
	
	/**
	 * Step rotor's depending on notch positions.
	 * 
	 * The Enigma machine moves the rotors to the next position
	 * on the key downshift, before the circuit for that encoding
	 * is made.
	 */
	private void stepRotors(){
				
		if (rotors[1].inNotch()){
			rotors[0].stepRotor();
			rotors[1].stepRotor();
			rotors[2].stepRotor();
		} else if (rotors[2].inNotch()){
			rotors[1].stepRotor();
			rotors[2].stepRotor();
		} else {
			rotors[2].stepRotor();
		}
	}
}
