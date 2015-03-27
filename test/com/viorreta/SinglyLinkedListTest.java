/**
 * 
 */
package com.viorreta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Viorreta
 *
 */
public class SinglyLinkedListTest {
	
	private SinglyLinkedList<String> list;
	Node<String> nodeA, nodeB, nodeC;
	
	
	@Before
	public void setUp() throws Exception {
		list = new SinglyLinkedList<String>();
		nodeA = new Node<String>();
		nodeB = new Node<String>();
		nodeC = new Node<String>();
		nodeA.setData("A");
		nodeB.setData("B");
		nodeC.setData("C");
	}


	@Test
	public void addFirstTest() {		
		list.addFirst(nodeA);
		list.addFirst(nodeB);
		
		assertSame(list.getFirstNode(), nodeB);
		assertSame(nodeB.getNext(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	@Test
	public void addFirstNullTest() {
		list.addFirst(null);		
		assertSame(list.getFirstNode(), null);
	}

	
	@Test
	public void addLastTest() {		
		list.addLast(nodeA);
		list.addLast(nodeB);
		
		assertSame(list.getFirstNode(), nodeA);
		assertSame(nodeA.getNext(), nodeB);
		assertNull(nodeB.getNext());
		assertSame(list.getNode(0), nodeA);
		assertSame(list.getNode(1), nodeB);
	}
	
	
	@Test
	public void addLastNullTest() {
		list.addLast(nodeA);
		list.addLast(null);		
		assertSame(list.getFirstNode(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	@Test
	public void addLastEmptyTest() {
		list.addLast(nodeA);
		assertSame(list.getFirstNode(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	
	@Test
	public void removeFirstBasicTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.removeFirst();
		
		assertEquals(list.size(), 1);
		assertSame(list.getFirstNode(), nodeB);
		assertNull(nodeB.getNext());
	}
	
	
	@Test
	public void removeFirstNullTest() {		
		list.removeLast();
		assertTrue(list.isEmpty());
	}
	
	
	@Test
	public void removeLastBasicTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.removeLast();
		
		assertEquals(list.size(), 1);
		assertSame(list.getFirstNode(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	
	@Test
	public void removeLastOneElementTest() {
		list.addLast(nodeA);
		list.removeLast();
		assertTrue(list.isEmpty());
	}
	
	
	@Test
	public void removeLastEmptyListTest() {		
		list.removeLast();
		assertTrue(list.isEmpty());
	}
	
	
	@Test
	public void isEmptyTrueTest() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void isEmptyTrueAfterRemovingTest() {
		list.addFirst(nodeA);
		list.removeFirst();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void isEmptyFalseTest() {
		list.addFirst(nodeA);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void sizeEmptyTest() {
		assertEquals(list.size(), 0);
	}
	
	
	@Test
	public void sizeNotEmptyTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);		
		assertEquals(list.size(), 2);
	}
	
	
	@Test
	public void getNodeTest() {
		list.addLast(nodeA);
		assertSame(list.getNode(0), nodeA);
	}
	
	@Test
	public void getNodeNullTest() {
		assertNull(list.getNode(0));
	}

	@Test
	public void getNodeIndexOutOfRangeTest() {
		assertNull(list.getNode(-1));
	}
	
	@Test
	public void getNodeLastNodeTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.addLast(nodeC);
		assertSame(list.getNode(2), nodeC);
	}
	
	@Test
	public void getNodeInvalidNodeTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.addLast(nodeC);
		assertNull(list.getNode(3));
	}
	
	@Test
	public void reverseIterativeBasicListTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.addLast(nodeC);
		
		list.reverseIterative();
		
		assertEquals(nodeC.getNext(), nodeB);
		assertEquals(nodeB.getNext(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	@Test
	public void reverseIterativeEmptyListTest() {
		list.reverseIterative();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void reverseIterativeOneNodeTest() {
		list.addLast(nodeA);
		list.reverseIterative();
		assertEquals(list.size(), 1);
		assertSame(list.getFirstNode(), nodeA);
	}
	
	
	@Test
	public void reverseRecursiveBasicListTest() {
		list.addLast(nodeA);
		list.addLast(nodeB);
		list.addLast(nodeC);
		
		list.reverseRecursive();
		
		assertSame(nodeC.getNext(), nodeB);
		assertSame(nodeB.getNext(), nodeA);
		assertNull(nodeA.getNext());
	}
	
	
	@Test
	public void reverseRecursiveEmptyListTest() {
		list.reverseRecursive();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void reverseRecursiveOneNodeTest() {
		list.addLast(nodeA);
		list.reverseRecursive();
		assertEquals(list.size(), 1);
		assertSame(list.getFirstNode(), nodeA);
	}
}