package com.johnflan.enigma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.johnflan.enigma.scrambler.plugboard.Plugboard;
import com.johnflan.enigma.scrambler.plugboard.PlugboardImpl;

public class PlugboardTest {
	
	Plugboard plugBoard;
	
	@BeforeMethod
	public void setup(){
		plugBoard = new PlugboardImpl();
	}
	
	@Test
	public void testWithNoConnectedPlugs(){
		
		char input = 'C';
		char output = plugBoard.convert(input);
		
		Assert.assertEquals(output, input);
	}
	
	@Test
	public void testWithInvalidMapping(){
		plugBoard.addCable('B', '8');
		char input = 'B';
		char output = plugBoard.convert(input);
		
		Assert.assertEquals(output, 'B');
	}
	
	@Test
	public void testConnectedPlug(){
		
		plugBoard.addCable('B', 'C');
		
		char output = plugBoard.convert('B');
		
		Assert.assertEquals(output, 'C');
		
		output = plugBoard.convert('C');
		
		Assert.assertEquals(output, 'B');
	}

}
