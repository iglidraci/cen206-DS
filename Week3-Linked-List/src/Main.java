public class Main {
	public static void main (String[] args) {
		CircularlyLinkList<Integer> circularlyLinkList = new CircularlyLinkList<>(1, 2, 3);
		circularlyLinkList.prepend(0);
		circularlyLinkList.prepend(-1);
		circularlyLinkList.prepend(-2);
		circularlyLinkList.append(4);
		System.out.println(circularlyLinkList);
		System.out.println("Rotate ...");
		circularlyLinkList.rotate();
		System.out.println(circularlyLinkList);
		System.out.println("Rotate ...");
		circularlyLinkList.rotate();
		System.out.println(circularlyLinkList);
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1, 2, 3);
		singlyLinkedList.append(4);
		singlyLinkedList.prepend(0);
		System.out.println(singlyLinkedList);
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(1, 2, 3);
		System.out.println("DLL: " + doublyLinkedList);
		doublyLinkedList.append(4);
		doublyLinkedList.prepend(0);
		System.out.println("DLL: " + doublyLinkedList);
	}
}
