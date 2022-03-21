import java.util.Arrays;
public class Main {
	public static void main (String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(2);
		list.prepend(3);
		list.prepend(4);
		list.prepend(5);
		list.prepend(6);
		list.append(1);
		list.append(9);
		System.out.println("Values: " + list);
		System.out.println("Head: " + list.head().value);
		System.out.println("Tail: " + list.tail().value);
		System.out.println("Tail.next: " + list.tail().next);
		System.out.println("Size: " + list.size());
		while (!list.isEmpty()) {
			System.out.println("Pop: " + list.pop());
		}
		System.out.println("Pop: " + list.pop());
		System.out.println("Values: " + list);
		list.prepend(6);
		list.append(1);
		list.append(9);
		System.out.println("Values: " + list);
		while (!list.isEmpty()) {
			System.out.println("Pop first: " + list.popFirst());
		}
		System.out.println("Values: " + list);
		list.append(2);
		System.out.println("Values: " + list);
		System.out.println("Remove: " + list.remove(100));
		System.out.println("Remove: " + list.remove(4));
		System.out.println("Remove: " + list.remove(6));
		System.out.println("Remove: " + list.remove(2));
		System.out.println("Values: " + list);
	}
}
