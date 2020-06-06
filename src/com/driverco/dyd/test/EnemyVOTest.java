package com.driverco.dyd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.driverco.dyd.model.EnemyVO;

public class EnemyVOTest {
	private static EnemyVO enemyVO; 

	@BeforeClass
	public static void init() {
		EnemyVOTest.enemyVO = new EnemyVO();
	}

	@Test
	public void testEnemyVO() {
		assertEquals(false, EnemyVOTest.enemyVO.getName().isEmpty() );		
		assertEquals(true, EnemyVOTest.enemyVO.getHp()> 0);		
	}
	@Test
	public void testAttack() {
		int prevhp = EnemyVOTest.enemyVO.getHp();
		EnemyVOTest.enemyVO.attack(10);
		assertEquals(prevhp -10 , EnemyVOTest.enemyVO.getHp());
	}
	@Test
	public void testAttackFull() {
		EnemyVOTest.enemyVO.attack(500);
		assertEquals(0 , EnemyVOTest.enemyVO.getHp());
	}

}
