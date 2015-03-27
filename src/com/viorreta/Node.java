/**
 * 
 */
package com.viorreta;

/**
 * Data structure that represents a node in a singly linked list.
 * 
 * @author Daniel Viorreta
 *
 * @param <V>
 */
public class Node<V> {

	// reference to the next node
	private Node<V> next;
	// data stored in the node
	private V data;

		
	public Node<V> getNext() {
		return next;
	}

	public void setNext(Node<V> next) {
		this.next = next;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}
}