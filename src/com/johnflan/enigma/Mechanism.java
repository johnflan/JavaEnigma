package com.johnflan.enigma;

public class Mechanism {
	
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;

	private Reflector reflector;
	private PlugBoard plugBoard;

	Mechanism(RotorType rotor1, RotorType rotor2, RotorType rotor3, ReflectorType reflector, PlugBoard plugBoard) throws Exception{
		if (rotor1 != null)
			this.rotor1 = new Rotor(rotor1);
		if (rotor2 != null)
			this.rotor2 = new Rotor(rotor2);
		if (rotor3 != null)
			this.rotor3 = new Rotor(rotor3);
		
		if (reflector != null)
			this.reflector = new Reflector(reflector);
		this.plugBoard = plugBoard;
	}
	
	public char encode(char pt) throws Exception{
		stepRotors();
		
		return rotor3(pt);
	}
	
	private char rotor1(char c) throws Exception{
		if (rotor1 == null)
			return reflector(c);
		return rotor1.out( reflector( rotor1.in(c) ));
	}
	
	private char rotor2(char c) throws Exception{
		if (rotor2 == null)
			return reflector(c);
		return rotor2.out( rotor1( rotor2.in(c) ));
	}
	
	private char rotor3(char c) throws Exception{
		if (rotor3 == null)
			return reflector(c);
		return rotor3.out( rotor2( rotor3.in(c) ));
	}
	
	private char reflector(char c) throws Exception{
		if (reflector == null)
			return c;
		char reflected = reflector.reflect(c);
		
		System.out.println(c + " -> " + reflected + " (reflected)");
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
