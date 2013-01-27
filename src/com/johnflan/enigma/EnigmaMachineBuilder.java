package com.johnflan.enigma;

import com.johnflan.enigma.plugboard.PlugBoard;
import com.johnflan.enigma.reflector.Reflector;
import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;

abstract class EnigmaMachineBuilder  {
	
	protected EnigmaMachine enigmaMachine;
	protected Scrambler scrambler;

	protected RotorType rotor1;
	protected int rotor1StartPosition;

	protected RotorType rotor2;
	protected int rotor2StartPosition;

	protected RotorType rotor3;
	protected int rotor3StartPosition;

	protected RotorType rotor4;
	protected int rotor4StartPosition;

	protected PlugBoard plugBoard;
	protected ReflectorType reflector;
	
	abstract public EnigmaMachineBuilder addRotor1(RotorType rotor);
	abstract public EnigmaMachineBuilder addRotor2(RotorType rotor);
	abstract public EnigmaMachineBuilder addRotor3(RotorType rotor);
	abstract public EnigmaMachineBuilder addRotor4(RotorType rotor);
	
	abstract public EnigmaMachineBuilder withStartPosition(int startPosition);
	
	abstract public EnigmaMachineBuilder addPlugBoard(PlugBoard plugboard);
	abstract public EnigmaMachineBuilder addReflector(Reflector plugboard);
	
	public EnigmaMachine build(){
		
		rotor1.setStartPosition(1);
		
		scrambler = new Scrambler(
				rotor1,
				rotor2,
				rotor3,
				rotor4,
				reflector,
				plugBoard);
		
		enigmaMachine = new EnigmaMachineImpl(scrambler);
		
		return enigmaMachine;
	}
	
	private interface AddRotor{
		public AddRotor2OrStartPos addRotor1(RotorType rotor);
	}
	
	private interface AddRotor2OrStartPos{
		public AddRotor3OrStartPos addRotor2(RotorType rotor);
		public AddRotor2 withStartPosition(int startPosition);
	}
	
	private interface AddRotor2{
		public AddRotor3OrStartPos addRotor2(RotorType rotor);
	}
	
	private interface AddRotor3OrStartPos{
		public AddRotor4OrStartPos addRotor3(RotorType rotor);
		public AddRotor3 withStartPosition(int startPosition);
	}
	
	private interface AddRotor3{
		public EnigmaMachineBuilder addRotor3(RotorType rotor);
	}
	
	private interface AddRotor4OrStartPos{
		public AddReflector addRotor4(RotorType rotor);
		public AddRotor4 withStartPosition(int startPosition);
	}
	
	private interface AddRotor4{
		public AddReflector addRotor4(RotorType rotor);
	}
	
	private interface AddReflector{
		public AddPlugBoardOrBuild addReflector(Reflector reflector);
	}
	
	private interface AddPlugBoardOrBuild{
		public Build addPlugBoard(PlugBoard plugboard);
		public EnigmaMachine build();
	}
	
	private interface Build{
		public EnigmaMachine build();
	}

}
