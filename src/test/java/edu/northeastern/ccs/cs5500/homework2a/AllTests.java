package edu.northeastern.ccs.cs5500.homework2a;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CardTest.class);
		suite.addTestSuite(DeckTest.class);
		//$JUnit-END$
		return suite;
	}

}
