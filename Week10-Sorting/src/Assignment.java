import java.util.Random;
import java.lang.StringBuilder;

public class Assignment {
  private static final int SIZE = 15;

  public static void main(String[] args) {
    Node head = buildRandomSLL(SIZE);
    System.out.println(head);
    Node head2 = new Node(2, new Node(3, new Node(4, new Node(5))));
    assertSorted(head2);
    sortSLL(head, SIZE);
    System.out.println(head);
    assertSorted(head);
  }
  private static Student[] getStudents() {
    Student[] students = new Student[10000];
    Random random = new Random();
    for(int i=0; i < 10000; i++) {
      students[i] = new Student(random.nextInt(43) + 18, "Student"+i);
    }
    return students;
  }
  private static void sortSLL(Node head, int size) {
    // write your solution here
  }
  private static Node buildRandomSLL(int size) {
    Random random = new Random();
    Node head = new Node(random.nextInt(100));
    Node current = head;
    while (--size > 0) {
      Node newNode = new Node(random.nextInt(100));
      current.next = newNode;
      current = current.next;
    }
    return head;
  }
  private static void assertSorted(Node head) {
    Node current = head;
    while (current != null && current.next != null) {
      assert current.val <= current.next.val;
      current = current.next;
    }
  }
  // Node definition
  private static class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
    public Node(int val) {
      this(val, null);
    }
    public String toString() {
      StringBuilder sb = new StringBuilder(""+this.val);
      Node current = this.next;
      while(current != null) {
        sb.append("->").append(""+current.val);
        current = current.next;
      }
      return sb.toString();
    }
  }
}
