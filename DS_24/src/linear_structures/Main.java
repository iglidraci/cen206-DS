package linear_structures;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.prepend(0);
        System.out.println(list.head());
        System.out.println(list.tail());
        System.out.println(Arrays.toString(list.toArray()));
    }
}
