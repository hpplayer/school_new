package com.intern.project.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTestTest {
	private static SimpleTest test = new SimpleTest();
	@Test
	public void testTestScore() {
		test.testCourse();
	}

	@Test
	public void testTestCourse() {
		test.testScore();
	}

	@Test
	public void testTestStudent() {
		test.testStudent();
	}

}
