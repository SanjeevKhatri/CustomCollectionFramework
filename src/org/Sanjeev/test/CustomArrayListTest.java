package org.Sanjeev.test;

import static org.junit.Assert.*;

import org.Sanjeev.Impl.CustomArrayList;
import org.junit.Before;
import org.junit.Test;

public class CustomArrayListTest {
	CustomArrayList empty;
	CustomArrayList one;
	CustomArrayList many;

	@Before
	public void setup() {
		empty = new CustomArrayList();
		one = new CustomArrayList();
		many = new CustomArrayList();

		one.add(1);
		many.add(1);
		many.add(2);
		many.add(3);
	}

	@Test
	public void isEmptyTest() {
		assertEquals(true, empty.isEmpty());
		assertEquals(false, one.isEmpty());
		assertEquals(false, many.isEmpty());
	}

	@Test
	public void addTest() {
		many.add(4);
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
		assertEquals(4, many.size());
	}

	@Test
	public void removeTest() {
		one.remove();
		many.remove();
		many.remove();
		assertEquals(0, one.size());
		assertEquals(1, many.size());
	}

	@Test
	public void getTest() {
		assertEquals((Integer) 1, one.get(0));
		assertEquals((Integer) 2, many.get(1));
		assertEquals(null, many.get(-1));
		assertEquals(null, many.get(5));
	}

	@Test
	public void sizeTest() {
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
		assertEquals(3, many.size());
	}

}
