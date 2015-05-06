package demo.threetier.ds.ll;


public class LLMain {

	public static void main(String[] args) {
		
		SinglyLinkedList linkedList = new SinglyLinkedList();

		linkedList.insertAtEnd("1");
		linkedList.insertAtEnd("2");
		linkedList.insertAtEnd("3");
		linkedList.insertAtEnd("4");

		System.out.println("Size of this list is => " + linkedList.getNodeCount());

		// print the list
		System.out.println(linkedList.printList());
	}
}
