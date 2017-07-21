package com.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class ModelTest {

	private Model model = new Model();

	@Test
	public void testAddAttribute() {
		model.addAttribute("attr", "value");
		String expect = "value";
		assertEquals(expect, model.getAttribute("attr"));
	}

}
