package demo.threetier.ds.ll;

public class SinglyLinkedList {

	private Node head;
	private int nodeCount;

	public SinglyLinkedList() {
		head = new Node(null);
		this.nodeCount = 0;
	}

	public void insertAtEnd(Object data) {

		// create a new node to insert
		Node newNode = new Node(data);

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
		Node currentNode = head.getNext();
		String output = "";
		while (currentNode != null) {
			output += "[" + currentNode.getData().toString() + "]";
			currentNode = currentNode.getNext();
		}

		return output;
	}

	public int getNodeCount() {
		return nodeCount;
	}

}
