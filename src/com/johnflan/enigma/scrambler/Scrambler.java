package com.johnflan.enigma.scrambler;

import com.johnflan.enigma.plugboard.PlugBoard;
import com.johnflan.enigma.reflector.Reflector;
import com.johnflan.enigma.reflector.ReflectorImpl;
import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.Rotor;
import com.johnflan.enigma.rotor.RotorImpl;
import com.johnflan.enigma.rotor.RotorType;

public class Scrambler {
	
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
	private Rotor rotor4;

	private Reflector reflector;
	private PlugBoard plugBoard;

	public Scrambler(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector) {
		configure(rotor1, rotor2, rotor3, null, reflector, null);
	}
	
	public Scrambler(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector, PlugBoard plugBoard) {
		configure(rotor1, rotor2, rotor3, null, reflector, plugBoard);
	}
	
	public Scrambler(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector, PlugBoard plugBoard) {
		configure(rotor1, rotor2, rotor3, rotor4, reflector, plugBoard);
	}
	
	private void configure(RotorType rotor1, RotorType rotor2, RotorType rotor3, RotorType rotor4, ReflectorType reflector, PlugBoard plugBoard){
		if (rotor1 != null)
			this.rotor1 = new RotorImpl(rotor1);
		
		if (rotor2 != null)
			this.rotor2 = new RotorImpl(rotor2);
		
		if (rotor3 != null)
			this.rotor3 = new RotorImpl(rotor3);
		
		if (rotor4 != null)
			this.rotor4 = new RotorImpl(rotor4);
		
		if (reflector != null)
			this.reflector = new ReflectorImpl(reflector);
		
		this.plugBoard = plugBoard;
		
	}
	
	public char encode(char pt) {
		stepRotors();
		
		return rotor3(pt);
	}
	
	private char rotor1(char c) {
		if (rotor1 == null)
			return reflector(c);
		return rotor1.out( reflector( rotor1.in(c) ));
	}
	
	private char rotor2(char c) {
		if (rotor2 == null)
			return reflector(c);
		return rotor2.out( rotor1( rotor2.in(c) ));
	}
	
	private char rotor3(char c) {
		if (rotor3 == null)
			return reflector(c);
		return rotor3.out( rotor2( rotor3.in(c) ));
	}
	
	private char reflector(char c) {
		if (reflector == null)
			return c;
		char reflected = reflector.reflect(c);
		
		return reflected;
	}
	
	private void stepRotors(){
		
		if (rotor2.inNotch()){
			rotor1.stepRotor();
			rotor2.stepRotor();
			rotor3.stepRotor();
		} else if (rotor3.inNotch()){
			rotor2.stepRotor();
			rotor3.stepRotor();
		} else {
			rotor3.stepRotor();
		}
	}
}
