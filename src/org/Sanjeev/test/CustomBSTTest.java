package org.Sanjeev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.Sanjeev.Impl.CustomBST;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomBSTTest {

	CustomBST<Integer> one;
	CustomBST<Integer> empty;
	CustomBST<Integer> many;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		one = new CustomBST<Integer>();
		many = new CustomBST<Integer>();
		empty = new CustomBST<Integer>();

		one.add(1);
		many.add(2);
		many.add(1);
		many.add(3);
	}

	@Test
	public void isEmptyTest() {
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}

	@Test
	public void addTest() {
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
		assertEquals(3, many.size());
		many.add(3);
		assertEquals(3, many.size());
		many.add(4);
		assertEquals(4, many.size());
	}

	@Test
	public void removeTest() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("List is Empty");
		empty.remove(1);
		one.remove(1);
		many.remove(2);
		many.remove(3);
		assertEquals(0, one.size());
		assertEquals(1, many.size());
	}

	@Test
	public void sizeTest() {
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
		assertEquals(3, many.size());
	}

	@Test
	public void getHeightTest() {
		many.add(-1);
		assertEquals(3, many.getHeight());
	}

	@Test
	public void printTreeTest() {
		many.add(-1);
		many.preOrderPrint();
		many.inOrderPrint();
		many.postOrderPrint();
		many.remove(2);
		many.preOrderPrint();
	}
}
