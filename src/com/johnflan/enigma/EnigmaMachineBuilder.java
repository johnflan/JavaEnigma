package com.johnflan.enigma;

import com.johnflan.enigma.plugboard.PlugBoard;
import com.johnflan.enigma.reflector.ReflectorType;
import com.johnflan.enigma.rotor.RotorType;
import com.johnflan.enigma.scrambler.Scrambler;

abstract class EnigmaMachineBuilder {
	
	
	public static class Builder implements AddRotor2, AddRotor3, AddRotor4OrAddReflector,
											AddReflector, AddPlugBoardOrBuild, Build{
		
		protected RotorType rotor1;
		protected int rotor1StartPosition = 0;

		protected RotorType rotor2;
		protected int rotor2StartPosition = 0;

		protected RotorType rotor3;
		protected int rotor3StartPosition = 0;

		protected RotorType rotor4;
		protected int rotor4StartPosition = 0;

		protected PlugBoard plugBoard;
		protected ReflectorType reflector;
		
		protected Scrambler scrambler;
		protected EnigmaMachine enigmaMachine;
		
		public Builder(RotorType rotor){
			rotor1 = rotor;
		}
		
		public Builder(RotorType rotor, int startPosition){
			rotor1 = rotor;
			rotor1StartPosition = startPosition;
		}
				
		@Override
		public AddRotor3 addRotor2(RotorType rotor) {
			rotor2 = rotor;
			return this;
		}

		@Override
		public AddRotor3 addRotor2(RotorType rotor, int startPosition) {
			rotor2 = rotor;
			rotor2StartPosition = startPosition;
			return this;
		}
		
		@Override
		public AddRotor4OrAddReflector addRotor3(RotorType rotor) {
			rotor3 = rotor;
			return this;
		}

		@Override
		public AddRotor4OrAddReflector addRotor3(RotorType rotor,
				int startPosition) {
			rotor3 = rotor;
			rotor3StartPosition = startPosition;
			return this;
		}
		
		@Override
		public AddReflector addRotor4(RotorType rotor) {
			rotor4 = rotor;
			return this;
		}

		@Override
		public AddReflector addRotor4(RotorType rotor, int startPosition) {
			rotor4 = rotor;
			rotor4StartPosition = startPosition;
			return this;
		}
		
		@Override
		public AddPlugBoardOrBuild addReflector(ReflectorType reflector) {
			return null;
		}

		@Override
		public Build addPlugBoard(PlugBoard plugboard) {
			return null;
		}
		
		@Override
		public EnigmaMachine build() {
			rotor1.setStartPosition(rotor1StartPosition);
			rotor2.setStartPosition(rotor2StartPosition);
			rotor3.setStartPosition(rotor3StartPosition);
			rotor4.setStartPosition(rotor4StartPosition);
			
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
	}
	
	public static AddRotor2 addRotor1(RotorType rotor){
		Builder builder = new Builder(rotor);
		return builder;
	}
	
	public static AddRotor2 addRotor1(RotorType rotor, int startPosition){
		Builder builder = new Builder(rotor);
		return builder;
	}
	
	
	public interface AddRotor1{
		public AddRotor2 addRotor1(RotorType rotor);
		public AddRotor2 addRotor1(RotorType rotor, int startPosition);
	}
	
	
	public interface AddRotor2{
		public AddRotor3 addRotor2(RotorType rotor);
		public AddRotor3 addRotor2(RotorType rotor, int startPosition);
	}
	
	public interface AddRotor3{
		public AddRotor4OrAddReflector addRotor3(RotorType rotor);
		public AddRotor4OrAddReflector addRotor3(RotorType rotor, int startPosition);
	}
	
	public interface AddRotor4OrAddReflector{
		public AddReflector addRotor4(RotorType rotor);
		public AddReflector addRotor4(RotorType rotor, int startPosition);
		public AddPlugBoardOrBuild addReflector(ReflectorType reflector);
	}
	
	public interface AddReflector{
		public AddPlugBoardOrBuild addReflector(ReflectorType reflector);
	}
	
	public interface AddPlugBoardOrBuild{
		public Build addPlugBoard(PlugBoard plugboard);
		public EnigmaMachine build();
	}
	
	public interface Build{
		public EnigmaMachine build();
	}
}
