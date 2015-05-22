package com.threetier.dataStructure.ll;

public class SinglyLinkedList {

	private Node head;
	private int nodeCount;

	public SinglyLinkedList() {
		head = null;
		this.nodeCount = 0;
	}

	public void insertAtEnd(Object data) {

		// create a new node to insert
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			this.nodeCount++;
			return;
		}
		// hold the head in a temp reference
		Node currentNode = head;

		// starting from beginning look for last node
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(newNode);
		this.nodeCount++;
	}

	public String printList() {
		Node currentNode = this.head;
		String output = "";
		while (currentNode != null) {
			output += "[" + currentNode.getData().toString() + "]";
			currentNode = currentNode.getNext();
		}

		return output;
	}

	/**
	 * this reverse the original list as head as links are exchanged. Reversed
	 * list has to be reversed again to get the original list
	 * 
	 * @param head
	 * @return head of the reversed list
	 */
	public Node reverseList(Node head) {

		Node current = null;
		Node next = null;

		if (head == null) {
			return head;
		}

		while (head != null) {
			next = head.getNext();
			head.setNext(current);
			current = head;
			head = next;
		}

		this.head = current;
		return this.head;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

}
