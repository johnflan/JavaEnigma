package com.johnflan.enigma;

public class Mechanism {
	
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
	private Rotor rotor4;
	private Reflector reflector;
	private PlugBoard plugBoard;

	Mechanism(Rotor rotor1, Rotor rotor2, Rotor rotor3, Rotor rotor4, Reflector reflector, PlugBoard plugBoard){
		this.rotor1 = rotor1;
		this.rotor2 = rotor2;
		this.rotor3 = rotor3;
		this.rotor4 = rotor4;
		this.reflector = reflector;
		this.plugBoard = plugBoard;
	}
	
	public char encode(char pt) throws Exception{
		incrementCounters();
		
		return rotor1(pt);
	}
	
	private char rotor1(char c) throws Exception{
		if (rotor1 == null)
			return reflector(c);
		return rotor1.out( rotor2( rotor1.in(c) ));
	}
	
	private char rotor2(char c) throws Exception{
		if (rotor2 == null)
			return reflector(c);
		return rotor2.out( rotor3( rotor2.in(c) ));
	}
	
	private char rotor3(char c) throws Exception{
		if (rotor3 == null)
			return reflector(c);
		return rotor3.out( rotor4( rotor3.in(c) ));
	}
	
	private char rotor4(char c) throws Exception{
		if (rotor4 == null)
			return reflector(c);
		return rotor4.out( reflector(rotor4.in(c)));
	}
	
	private char reflector(char c) throws Exception{
		if (reflector == null)
			return c;
		return reflector.reflect(c);
	}
	
	private void incrementCounters(){
		
		if (rotor1 != null){
			Boolean incr = rotor1.incrementCounter();
			if (incr && rotor2 != null){
				incr = rotor2.incrementCounter();
				if (incr && rotor3 != null){
					incr = rotor3.incrementCounter();
					if (incr && rotor4 != null){
						incr = rotor4.incrementCounter();
					}
				}
			}
		}
	}
	
}
