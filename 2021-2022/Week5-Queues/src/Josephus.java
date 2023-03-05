public class Josephus {
    public static void main(String[] args) {
        String[] names = {"Foo", "Bar", "Baz", "Josephus", "Quux", "Grault", "Thud"};
        Integer[] nrs = {1, 2, 3, 4, 5,};
        CircularQueue<String> q1 = buildQueue(names);
        CircularQueue<Integer> q2 = buildQueue(nrs);
        String name = solver(q1, 3);
        System.out.printf("Winner: %s\n", name);
        Integer nr = solver(q2, 2);
        System.out.println("Winner: " + nr);
    }

    private static<T> CircularQueue<T> buildQueue(T[] array) {
        CircularQueue<T> queue = new CircularQueue<>();
        for(T value: array)
            queue.enqueue(value);
        return queue;
    }

    private static<T> T solver(CircularQueue<T> queue, int k) {
        if (queue.isEmpty()) return null;
        while (queue.size() > 1) {
            queue.rotate(k-1);
            System.out.printf("Killed: %s\n", queue.dequeue().toString());
        }
        return queue.dequeue();
    }
}
