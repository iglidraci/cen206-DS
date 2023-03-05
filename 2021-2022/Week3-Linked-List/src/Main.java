

public class Main {
	public static void main (String[] args) {
		singlyLinkedList();
	}

	private static void singlyLinkedList() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.append(1);
		sll.append(2);
		assert sll.head() == 1;
		assert sll.tail() == 2;
		sll.prepend(0);
		sll.prepend(-1);
		sll.append(3);
		assert sll.head() == -1;
		assert sll.tail() == 3;
		sll.pop();
		sll.popFirst();
		assert sll.head() == 0;
		assert sll.tail() == 2;
		assert sll.indexOf(sll.tail()) == sll.getSize() - 1;
		System.out.println(sll);
		sll.reverse();
		sll.prepend(3);
		sll.prepend(4);
		System.out.println(sll);
		System.out.println("Rotate list by 3");
		sll.rotate(3);
		System.out.println(sll);
		sll.append(-1);
		sll.append(-2);
		sll.append(-3);
		sll.prepend(5);
		sll.prepend(6);
		sll.prepend(7);
		System.out.println(sll);
		var parts = sll.split(3);
		for (SinglyLinkedList<Integer> part : parts)
			System.out.println(part);
	}
}
