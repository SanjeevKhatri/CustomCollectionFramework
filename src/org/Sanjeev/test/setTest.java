package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	Set empty;
	Set one;
	Set many;
	@Before
	public void setup(){
		empty = new Set();
		one = new Set();
		one.add("one");
		many  = new Set();
		many.add("two");
		many.add("three");
	}
	
	@Test
	public void isEmpty(){
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}
	
	@Test
	public void sizeTest(){
		assertEquals(0,empty.size());
		assertEquals(1,one.size());
		assertEquals(2,many.size());
	}
	
	@Test
	public void addTest(){
		Set many = new Set();
		many.add("one");
		assertTrue(many.contains("one"));
		assertFalse(many.contains("two"));
	}
	
	@Test
	public void removeTest(){
		Set check = new Set();
		check.add("one");
		assertTrue(check.contains("one"));
		check.remove("one");
		assertFalse(check.contains("one"));
	}
	
	@Test
	public void isUniqueTest(){
		Set check = new Set();
		check.add("one");
		check.add("one");
		assertEquals(1,check.size());
	}
	
	@Test
	public void resizeTest(){
		Set check = new Set();
		check.add("one");
		check.add("two");
		check.add("three");
		check.add("four");
		assertEquals(4,check.size());
	}
	

	
}
