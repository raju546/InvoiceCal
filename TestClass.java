package com.cg.service;

import junit.framework.TestCase;

public class TestClass extends TestCase {
	
	Service s = null;
	
	@Override
	public void setUp() throws Exception{
		super.setUp();
		s = new Service();
	}
	
	@Override
	public void tearDown() throws Exception{
		super.tearDown();
		s=null;
	}
	
	public void testCalculateTransportationCharges()
	{
		double x = s.calculateTransportationCharges(10, 20);
		assertEquals(400.0,x);
		double y = s.calculateTransportationCharges(30, 40);
		assertEquals(2400.0, y);	
	}
	
	public void testCalculateSGST()
	{
		double x = s.calculateSGST(52000.0);
		assertEquals(1820.0, x);
		double y = s.calculateSGST(20000.0);
		assertEquals(700.0, y);	
	}
	
	public void testCalculateCGST()
	{
		double x = s.calculateCGST(52000.0);
		assertEquals(1820.0, x);
		double y = s.calculateCGST(20000.0);
		assertEquals(700.0, y);	
	}
	

}
