/**
 * 
 */
package com.viorreta;

/**
 * Data structure representing a sequence of nodes. Null nodes are not allowed.
 * 
 * @author Daniel Viorreta
 * @param <V>
 *
 */

public class SinglyLinkedList<V> {

	// First node of list, null for empty list
	private Node<V> firstNode;
	
	
	/**
	 * Get the first node
	 * @return
	 */
	public Node<V> getFirstNode() {
		return firstNode;
	}


	/**
	 * Insert a node at beginning of list. Does nothing for null nodes.
	 * @param node
	 */
	public void addFirst(Node<V> node) {
		if (node == null) {
			return;
		}
		node.setNext(this.firstNode);
		// new node is now the first node
		this.firstNode = node;
	}

		
	/**
	 * Insert a node at end of list
	 * @param node
	 */
	public void addLast(Node<V> node) {
		if (this.isEmpty()) {
			this.firstNode = node;
		} else {			
			Node<V> currentNode = this.firstNode;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}

	
	/**
	 * Remove the first node of list. Does nothing if the list is empty.
	 */
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.firstNode = this.firstNode.getNext();
		}
	}

	
	/**
	 * Remove the last node of list. Does nothing if the list is empty.
	 */
	public void removeLast(){
		if (this.isEmpty()) {
			return;
		} else if(this.firstNode.getNext() == null) {
			this.firstNode = null;
		} else {
			Node<V> previousNode = this.firstNode;

			while(previousNode.getNext().getNext() != null) {
				previousNode = previousNode.getNext();
			}
			previousNode.setNext(null);
		}
	}

	
	/**
	 * Return true if and only if list is empty
	 * @return
	 */
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (this.firstNode == null) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	
	/**
	 * Return the number of nodes of list
	 * @return
	 */
	public int size() {
		Node<V> node = this.firstNode;
		int size = 0;
		while (node != null) {
			size = size + 1;
			node = node.getNext();
		}
		return size;
	}
	
	
		
	/**
	 * Get the node located at the index position of list
	 * @param index
	 * @return
	 */
	public Node<V> getNode(int index) {
		Node<V> node = this.firstNode;
		
		// return if the list is empty or the index is out of range 
		if (index < 0 || this.isEmpty()) {
			return null;
		}
		
		for (int i=1; i <= index; i++){
			node = node.getNext();
			// return if index is out of bounds
			if (node == null) {
				return null;
			}
		}
		
		return node;
	}
	
	
	/**
	 * Reverse the nodes of list iteratively
	 */
	public void reverseIterative() {
		Node<V> reverse = null;
		Node<V> current = this.firstNode;
		//iterate through the nodes swapping the pointing the current
		//node to the reverse node
		while (current != null) {
			Node<V> next = current.getNext();
			current.setNext(reverse);
			reverse = current;
			current = next;
		}
		this.firstNode = reverse;
	}

	
	/**
	 * Reverse the nodes of list recursively
	 */
	public void reverseRecursive() {
		reverseRecursive(firstNode);
	}

	
	/**
	 * Reverse the nodes of list recursively from a node
	 * @param node
	 */
	private void reverseRecursive(Node<V> node) {
		if (node == null) {
			return;
		}
		if (node.getNext() == null) {
			this.firstNode = node;
			return;
		}
		reverseRecursive(node.getNext());
		//point the next of the current node to the current node
		node.getNext().setNext(node);
		//current node is the last node, so set the next to null
		node.setNext(null);		
	}
}