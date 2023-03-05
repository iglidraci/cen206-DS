import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayQueue<>(4);
        Queue<Integer> q2 = new LinkedQueue<>();
        Queue<Integer> q3 = new StackQueue<>();
        testQueue(q1);
        testQueue(q2);
        testQueue(q3);
        System.out.println(q1);
        System.out.println(q2);
        Deque<Integer> dq = new ArrayDeque<>(5);
        testDeque(dq);
        System.out.println(dq);
        int[] deck = {17,13,11,2,3,5,7};
        int[] result = revealCards(deck);
        System.out.println("Cards: " + Arrays.toString(result));
    }

    private static int[] revealCards(int[] deck) {
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            indices.addLast(i);
        }
        int[] answer = new int[deck.length];
        Arrays.sort(deck);
        for (int card: deck) {
            answer[indices.removeFirst()] = card;
            if (!indices.isEmpty())
                indices.addLast(indices.removeFirst());
        }
        return answer;
    }

    private static void testDeque(Deque<Integer> deque) {
        assert deque.isEmpty();
        deque.addLast(1);
        deque.addLast(2);
        assert deque.first() == 1;
        assert deque.last() == 2;
        deque.addLast(3);
        assert deque.last() == 3;
        deque.addFirst(0);
        deque.addFirst(-1);
        assert deque.first() == -1;
        assert deque.removeFirst() == -1;
        assert deque.removeLast() == 3;
        deque.addFirst(-2);
        assert deque.first() == -2;
        deque.addLast(4);
        assert deque.last() == 4;

    }

    private static void testQueue(Queue<Integer> queue) {
        assert queue.isEmpty();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue() == 1;
        assert queue.peek() == 2;
        queue.enqueue(4);
        queue.enqueue(5);
        assert queue.dequeue() == 2;
        assert queue.peek() == 3;
        queue.enqueue(6);
        assert queue.dequeue() == 3;
        assert queue.dequeue() == 4;
    }
}
