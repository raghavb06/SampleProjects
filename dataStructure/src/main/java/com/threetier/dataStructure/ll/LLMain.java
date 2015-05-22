package com.threetier.dataStructure.ll;

public class LLMain {
	public static void main(String[] args) {

		SinglyLinkedList linkedList = new SinglyLinkedList();

		linkedList.insertAtEnd("1");
		linkedList.insertAtEnd("21");
		linkedList.insertAtEnd("13");
		linkedList.insertAtEnd("41");

		System.out.println("Size of this list is => "
				+ linkedList.getNodeCount());

		// print the list
		System.out.println(linkedList.printList());

		// reverse the list
		linkedList.reverseList(linkedList.getHead());

		// print the list
		System.out.println(linkedList.printList());
	}
}
