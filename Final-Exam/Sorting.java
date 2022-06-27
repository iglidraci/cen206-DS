import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Sorting {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.add(1); q1.add(2); q1.add(3);
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(2); q1.add(3); q1.add(4);
        Queue<Integer> q3 = merge(q1, q2);
        while (!q3.isEmpty()) {
            System.out.println(q3.remove());
        }
    }

    static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        /*
         * Suppose you meet a sasquatch that needs your help
         * He has two sorted queues where the min value is in front of the queue
         * He's asking you to merge these two sorted queues into a single queue
         * You think it's easy but the sasquatch wants the final queue to be sorted
         * in descending order (min value in the back) while offering you only
         * queues and stacks as auxiliary tools (fortunately he has plenty of them)
         */
        Queue<Integer> q3 = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        while (!(q1.isEmpty() || q2.isEmpty())) {
            if (q1.peek() < q2.peek())
                stack.push(q1.remove());
            else
                stack.push(q2.remove());
        }
        while (!q1.isEmpty()) {
            stack.push(q1.remove());
        }
        while (!q2.isEmpty()) {
            stack.push(q2.remove());
        }
        while (!stack.isEmpty()) {
            q3.add(stack.pop());
        }
        return q3;
    }
}
