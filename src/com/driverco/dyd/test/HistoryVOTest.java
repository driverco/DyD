package com.driverco.dyd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.driverco.dyd.model.HistoryVO;

public class HistoryVOTest {

	private static HistoryVO histVO; 

	@BeforeClass
	public static void init() {
		HistoryVOTest.histVO = new HistoryVO();
	}
	
	@Test
	public void testHistoryVO() {
		assertEquals(HistoryVO.LOC_TOWN, HistoryVOTest.histVO.getLocation());		
		assertEquals(HistoryVO.STAT_OK, HistoryVOTest.histVO.getStatus());		
	}
	@Test
	public void testSetStatus() {
		HistoryVOTest.histVO.setStatus(HistoryVO.STAT_OK);
		assertEquals(HistoryVO.STAT_OK, HistoryVOTest.histVO.getStatus());
		HistoryVOTest.histVO.setStatus(HistoryVO.STAT_BATTLE);
		assertEquals(HistoryVO.STAT_BATTLE, HistoryVOTest.histVO.getStatus());
		HistoryVOTest.histVO.setStatus(HistoryVO.STAT_DEAD);
		assertEquals(HistoryVO.STAT_DEAD, HistoryVOTest.histVO.getStatus());
		HistoryVOTest.histVO.setStatus(HistoryVO.STAT_OK);//after dead no status change
		assertEquals(HistoryVO.STAT_DEAD, HistoryVOTest.histVO.getStatus());//this will fail to show the process

	}

}
