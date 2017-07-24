package com.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class VerifierTest {

	private Verifier verifier = new Verifier();
	
	@Test
	public void testVerifyEnterParamLessThanMin() {
		boolean expected = false;
		boolean actual = verifier.verifyEnter(0, 1, 15);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerifyEnterParamMoreThanMin() {
		boolean expected = false;
		boolean actual = verifier.verifyEnter(16, 1, 15);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerifyEnterCorrectParam() {
		boolean expected = true;
		boolean actual = verifier.verifyEnter(3, 1, 15);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerifyRangeWrongMinParam() {
		boolean expected = false;
		boolean actual = verifier.verifyRange(0, 15, 0, 100, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerifyRangeWrongMaxParam() {
		boolean expected = false;
		boolean actual = verifier.verifyRange(1, 100, 0, 100, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerifyRangeWrongAvailableDifferenceParam() {
		boolean expected = false;
		boolean actual = verifier.verifyRange(1, 5, 0, 100, 5);
		assertEquals(expected, actual);
	}

}
