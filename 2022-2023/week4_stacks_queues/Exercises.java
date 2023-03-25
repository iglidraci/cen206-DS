import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        System.out.println(isMatched("[(5+x)−(y+z)]"));
        System.out.println(isMatched("[(5+x)−(y+z)"));
        System.out.println(isHTMLMatched("<body><p>Hello world</p></body>"));
        System.out.println(isHTMLMatched("<body><p>Hello world</p></head>"));
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};

        System.out.println(josephusProblem(buildCircle(a1), 3));
        System.out.println(josephusProblem(buildCircle(a2), 10));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
    }

    private static Queue<String> buildCircle(String[] names) {
        Queue<String> queue = new ArrayQueue<>();
        for(String name : names) queue.enqueue(name);
        return queue;
    }

    /**
     * [(5+x)−(y+z)]
     * @param expression is an arithmetic expression containing parentheses, braces, and brackets
     * @return true if all opening symbols correspond to their closing symbols
     */
    static boolean isMatched(String expression) {
        return false;
    }

    /**
     * Checks whether the given html is correct or not.
     * The HTML document should have matching tags, no mismatches
     * @param html string
     * @return true if all opening tags match their closing tags, false otherwise
     */
    static boolean isHTMLMatched(String html) {
        return false;
    }

    /**
     *
     * @param queue a group of n people sitting in a circle.
     * @param k every kth person is removed from the circle
     * @return the last one standing in the circle
     */
    static String josephusProblem(Queue<String> queue, int k) {
        return null;
    }

    /**
     * You are given an array asteroids of integers representing asteroids in an array.
     * For each asteroid, the absolute value represents its size, and the sign represents
     * its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
     * If two asteroids meet, the smaller one will explode. If both are the same size, both will explode
     * Find out the state of the asteroids after all collisions
     * @param asteroids int array representing asteroid magnitude and direction
     * @return the state of asteroids after collisions in an array
     */
    static int[] asteroidCollision(int[] asteroids) {
        return null;
    }
}
