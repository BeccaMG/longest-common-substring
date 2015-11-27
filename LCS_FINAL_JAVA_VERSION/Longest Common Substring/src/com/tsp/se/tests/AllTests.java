package com.tsp.se.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * This Test suite should be run and it will call all other tests
 *
 */


@RunWith(Suite.class)
@SuiteClasses({ FilesWriterTest.class, FilesReaderTest.class,
		LongestCommonSubstringFinderTest.class, RandomStringGenerationTest.class })
public class AllTests {

}
