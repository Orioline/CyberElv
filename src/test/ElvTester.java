package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elv.common.Elv;
import elv.common.Image;

public class ElvTester {
	private static Elv nand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nand = new Elv();
		
		nand.learn(new Image("()", ""));
		nand.learn(new Image("(1)", "1"));
		nand.learn(new Image("(0)", "0"));
		
		nand.learn(new Image("1&1", "1"));
		nand.learn(new Image("1&0", "0"));
		nand.learn(new Image("0&1", "0"));
		nand.learn(new Image("0&0", "0"));
		
		nand.learn(new Image("1|1", "1"));
		nand.learn(new Image("1|0", "1"));
		nand.learn(new Image("0|1", "1"));
		nand.learn(new Image("0|0", "0"));
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private boolean assert_equals(String expected, String real)
	{
		if(!expected.equals(real)){
			fail();
			return false;
		}
		return true;
	}

	@Test
	public void test() {
		assert_equals(nand.IPO("1"), "1");
		assert_equals(nand.IPO("0"), "0");
		assert_equals(nand.IPO("(1)"), "1");
		assert_equals(nand.IPO("1&1"), "1");
		assert_equals(nand.IPO("1&0"), "0");
		assert_equals(nand.IPO("0&1"), "0");
		assert_equals(nand.IPO("0&0"), "0");
		assert_equals(nand.IPO("1|1"), "1");
		assert_equals(nand.IPO("1|0"), "1");
		assert_equals(nand.IPO("0|1"), "1");
		assert_equals(nand.IPO("0|0"), "0");
		assert_equals(nand.IPO("1&1&1&1"), "1");
		assert_equals(nand.IPO("1|1|1|1"), "1");
		assert_equals(nand.IPO("1&1&0&1"), "0");
		assert_equals(nand.IPO("0|0|0|1"), "1");
		
		assert_equals(nand.IPO("0|0&1"), "0");
		assert_equals(nand.IPO("1|(0&1)"), "1");
		
		assert_equals(nand.IPO("0&1|1"), "1");
		assert_equals(nand.IPO("0&(1|1)"), "0");
	}

}
