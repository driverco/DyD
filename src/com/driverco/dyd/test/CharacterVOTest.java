package com.driverco.dyd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.driverco.dyd.model.CharacterVO;

public class CharacterVOTest {
	private static CharacterVO charVO; 
	
	@BeforeClass
	public static void init() {
		CharacterVOTest.charVO = new CharacterVO();
	}
	
	@Test
	public void testCharacterVO() {
		assertEquals(false, CharacterVOTest.charVO.getName().isEmpty() );		
		assertEquals(true, CharacterVOTest.charVO.getCurrentHp() > 0 );		
		assertEquals(true, CharacterVOTest.charVO.getHp() > 0 );		
		assertEquals(true, CharacterVOTest.charVO.getPower() > 0 );		
		assertEquals(true, CharacterVOTest.charVO.getDefense() > 0 );		
	}

	@Test
	public void testAttack() {
		CharacterVOTest.charVO.attack(10);
		assertEquals(true, CharacterVOTest.charVO.getHp() >= CharacterVOTest.charVO.getCurrentHp());
		if (CharacterVOTest.charVO.getHp()>=10) {
			assertEquals(true, CharacterVOTest.charVO.getCurrentHp() > CharacterVOTest.charVO.getHp()-10);
		}else {
			assertEquals(true, CharacterVOTest.charVO.getCurrentHp() > 0);
		}
	}
	
	@Test
	public void testHeal() {
		CharacterVOTest.charVO.heal();
		assertEquals(CharacterVOTest.charVO.getHp(), CharacterVOTest.charVO.getCurrentHp() );
	}

	@Test
	public void testAttackFull() {
		CharacterVOTest.charVO.attack(CharacterVOTest.charVO.getHp()*1000);
		assertEquals(0, CharacterVOTest.charVO.getCurrentHp() );
	}


}
