package com.johnflan.enigma;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.johnflan.enigma.Reflector;
import com.johnflan.enigma.ReflectorType;


public class ReflectorTest {
	
	private Reflector reflector;
	
	@Test
	public void testReflectorAMapping() throws Exception{
		//(AY) (BR) (CU) (DH) (EQ) (FS) (GL) (IP) (JX) (KN) (MO) (TZ) (VW)
		
		reflector = new Reflector(ReflectorType.Umkehrwalze_B);
		Assert.assertEquals(reflector.reflect('A'), 'Y');
		Assert.assertEquals(reflector.reflect('R'), 'B');
		Assert.assertEquals(reflector.reflect('C'), 'U');
		Assert.assertEquals(reflector.reflect('H'), 'D');
		Assert.assertEquals(reflector.reflect('E'), 'Q');
		Assert.assertEquals(reflector.reflect('S'), 'F');
		Assert.assertEquals(reflector.reflect('G'), 'L');
		Assert.assertEquals(reflector.reflect('P'), 'I');
		Assert.assertEquals(reflector.reflect('J'), 'X');
		Assert.assertEquals(reflector.reflect('N'), 'K');
		Assert.assertEquals(reflector.reflect('M'), 'O');
		Assert.assertEquals(reflector.reflect('Z'), 'T');
		Assert.assertEquals(reflector.reflect('V'), 'W');
		
	}
	
	@Test
	public void testReflectorBMapping() throws Exception{
		//AF BV CP DJ EI GO HY KR LZ MX NW QT SU
		reflector = new Reflector(ReflectorType.Umkehrwalze_C);
		Assert.assertEquals(reflector.reflect('A'), 'F');
		Assert.assertEquals(reflector.reflect('V'), 'B');
		Assert.assertEquals(reflector.reflect('C'), 'P');
		Assert.assertEquals(reflector.reflect('J'), 'D');
		Assert.assertEquals(reflector.reflect('E'), 'I');
		Assert.assertEquals(reflector.reflect('O'), 'G');
		Assert.assertEquals(reflector.reflect('H'), 'Y');
		Assert.assertEquals(reflector.reflect('R'), 'K');
		Assert.assertEquals(reflector.reflect('L'), 'Z');
		Assert.assertEquals(reflector.reflect('X'), 'M');
		Assert.assertEquals(reflector.reflect('N'), 'W');
		Assert.assertEquals(reflector.reflect('T'), 'Q');
		Assert.assertEquals(reflector.reflect('S'), 'U');
		
	}

}
