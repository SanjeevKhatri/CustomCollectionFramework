package org.Sanjeev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.Sanjeev.Impl.CustomLinkedList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomLinkedListTest {

	CustomLinkedList<Object> one;
	CustomLinkedList<Object> empty;
	CustomLinkedList<Object> many;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		one = new CustomLinkedList<Object>();
		many = new CustomLinkedList<Object>();
		empty = new CustomLinkedList<Object>();

		one.add("one");
		many.add("one");
		many.add("two");
		many.add("three");
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
	}

	@Test
	public void removeTest() {

		thrown.expect(NullPointerException.class);
		thrown.expectMessage("List is Empty");
		empty.remove();
		one.remove();
		many.remove();
		many.remove();
		assertFalse(one.contains("one"));
		assertTrue(many.contains("three"));
		assertFalse(many.contains("one"));
		assertFalse(many.contains("two"));
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
	public void getTest() {
		assertEquals(null, empty.get(0));
		assertEquals("one", one.get(0));
		assertEquals("one", many.get(0));
		assertEquals("two", many.get(1));
		assertEquals("three", many.get(2));
		assertEquals(null, many.get(-1));
		assertEquals(null, many.get(3));
	}

	@Test
	public void containsTest() {
		assertFalse(empty.contains("abc"));
		assertTrue(one.contains("one"));
		assertFalse(one.contains("two"));
		assertTrue(many.contains("one"));
		assertTrue(many.contains("two"));
		assertTrue(many.contains("three"));
		assertFalse(many.contains("four"));
	}

	@Test
	public void clearTest() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("List is Empty");
		empty.clear();
		one.clear();
		many.clear();
		assertFalse(one.contains("one"));
		assertFalse(many.contains("one"));
		assertFalse(many.contains("two"));
		assertFalse(many.contains("three"));
	}

	@Test
	public void addAllTest() {
		one.add("nine");
		one.add("ten");
		many.addAll(one);
		assertEquals(6, many.size());
		assertTrue(many.contains("nine"));
		assertTrue(many.contains("ten"));
		assertEquals(3, one.size());
	}

	@Test
	public void equalsTest() {
		assertFalse(many.equals(empty));
		assertFalse(many.equals(one));
		one.add("two");
		one.add("three");
		assertTrue(many.equals(one));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void containsAllTest() {
		List l = new ArrayList();
		l.add("one");
		l.add("two");
		l.add("two");
		assertTrue(many.containsAll(l));
		l.add("three");
		assertTrue(many.containsAll(l));
		l.add("five");
		assertFalse(many.containsAll(l));
	}
}
