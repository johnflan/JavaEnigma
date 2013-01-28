package com.johnflan.enigma;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.Scrambler;

public class EnigmaMachineTest {
	
	EnigmaMachine enigmaMachine;
	Scrambler scrambler;

	
	@BeforeMethod
	public void setup(){
		
		scrambler = mock(Scrambler.class);
		enigmaMachine = new EnigmaMachineImpl(scrambler);
		
		when(scrambler.encode('A')).thenReturn('A');
		when(scrambler.encode('B')).thenReturn('B');
		when(scrambler.encode('C')).thenReturn('C');
		when(scrambler.encode('D')).thenReturn('D');
		when(scrambler.encode('E')).thenReturn('E');
		when(scrambler.encode('F')).thenReturn('F');
		when(scrambler.encode('G')).thenReturn('G');
		when(scrambler.encode('H')).thenReturn('H');
		when(scrambler.encode('I')).thenReturn('I');
		when(scrambler.encode('J')).thenReturn('J');
		when(scrambler.encode('K')).thenReturn('K');
		when(scrambler.encode('L')).thenReturn('L');
		when(scrambler.encode('M')).thenReturn('M');
		when(scrambler.encode('N')).thenReturn('N');
		when(scrambler.encode('O')).thenReturn('O');
		when(scrambler.encode('P')).thenReturn('P');
		when(scrambler.encode('Q')).thenReturn('Q');
		when(scrambler.encode('R')).thenReturn('R');
		when(scrambler.encode('S')).thenReturn('S');
		when(scrambler.encode('T')).thenReturn('T');
		when(scrambler.encode('U')).thenReturn('U');
		when(scrambler.encode('V')).thenReturn('V');
		when(scrambler.encode('W')).thenReturn('W');
		when(scrambler.encode('X')).thenReturn('X');
		when(scrambler.encode('Y')).thenReturn('Y');
		when(scrambler.encode('Z')).thenReturn('Z');
	}
	
	@Test
	public void testTextValidation(){
		String textWithInvalidCharacters = "Fairest Cordelia, that art most rich, being poor; Most choice, forsaken; and most loved, despised!";
		String validText = "FAIRESTCORDELIATHATARTMOSTRICHBEINGPOORMOSTCHOICEFORSAKENANDMOSTLOVEDDESPISED";
		
		String machineOutput = enigmaMachine.encrypt(textWithInvalidCharacters);
		
		Assert.assertEquals(machineOutput, validText);
		
	}
}
