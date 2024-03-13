package linear_structures;

public class QueueExercises {
    public static void main(String[] args) {
        // let's gather some data
        for(int i=1; i <= 16; i++) {
            Integer lastManStanding = generalJosephusProblem(i, 2);
            System.out.printf("n=%d, safe position = %d%n", i, lastManStanding);
        }
        System.out.println(josephusProblem(77));
        System.out.println(josephusProblem(32));
        System.out.println(josephusProblem(41));
    }
    /**
     *
     * @param n people sitting in a circle.
     * @param k every kth person is slaughtered (I know, a bit brutal) from the circle
     * @return the last one standing in the circle
     */
    static int generalJosephusProblem(int n, int k) {
        Queue<Integer> queue = new ArrayQueue<>(n);
        for(int i=1; i <= n; i++)
            queue.enqueue(i);
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++)
                queue.enqueue(queue.dequeue()); // rotate
            int removed = queue.dequeue(); // remove the kth person from the circle
            // System.out.println("Person " + removed + " is out"); // uncomment if you want to see the order of slaughtering
        }
        return queue.dequeue(); // the last one standing
    }
    // assumed with k = 2
    // explanation in class
    static int josephusProblem(int n) {
        return ~Integer.highestOneBit(n*2) & ((n<<1) | 1);
    }
}
