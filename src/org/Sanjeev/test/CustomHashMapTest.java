package org.Sanjeev.test;

import static org.junit.Assert.*;

import org.Sanjeev.Impl.CustomHashMap;
import org.junit.Before;
import org.junit.Test;

public class CustomHashMapTest {

	CustomHashMap<Object, Object> empty;
	CustomHashMap<Object, Object> one;
	CustomHashMap<Object, Object> many;

	@Before
	public void setup() {
		empty = new CustomHashMap<Object, Object>();
		one = new CustomHashMap<Object, Object>();
		many = new CustomHashMap<Object, Object>();
		one.put("one", "oneValue");
		many.put("one", "oneValue");
		many.put("two", "twoValue");
		many.put("three", "threeValue");
	}

	@Test
	public void isEmptyTest() {
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}

	@Test
	public void putTest() {
		many.put("four", "fourValue");
		many.put("five", "fiveValue");

		assertEquals(1, one.size());
		assertEquals(5, many.size());
		assertEquals("fiveValue", many.get("five"));
	}

	@Test
	public void getTest() {
		many.put("five", "fiveValue");
		assertEquals("fiveValue", many.get("five"));
		assertEquals("oneValue", many.get("one"));
		assertEquals("oneValue", one.get("one"));
	}

	@Test
	public void containsKeyTest() {
		assertTrue(one.containsKey("one"));
		assertFalse(one.containsKey("hundred"));
	}
	
	@Test
	public void containsValueTest(){
		assertTrue(one.containsValue("oneValue"));
		assertFalse(one.containsValue("hundred"));
	}
	
	@Test
	public void removeTest(){
		assertTrue(many.containsValue("oneValue"));
		assertTrue(many.containsKey("one"));
		many.remove("one");
		assertFalse(many.containsValue("oneValue"));
		assertFalse(many.containsKey("one"));
	}
}
