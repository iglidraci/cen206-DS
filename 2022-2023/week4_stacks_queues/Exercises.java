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
        Stack<Character> stack = new LinkedStack<>();
        String opening = "([{"; // opening delimiters
        String closing = ")]}"; // closing delimiters
        for(char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) // c is one of the opening delimiters
                stack.push(c);
            else if (closing.indexOf(c) != -1) { // c is a closing delimiter
                if (stack.isEmpty()) return false; // there are closing delimiters without an opening match
                if(closing.indexOf(c) != opening.indexOf(stack.pop()))
                    return false; // opening and closing do no match
            }
        }
        return stack.isEmpty(); // if not empty, then we have opening delimiters without closing ones
    }

    /**
     * Checks whether the given html is correct or not.
     * The HTML document should have matching tags, no mismatches
     * @param html string
     * @return true if all opening tags match their closing tags, false otherwise
     */
    static boolean isHTMLMatched(String html) {
        Stack<String> stack = new LinkedStack<>();
        int i = html.indexOf('<'); // find the first <
        while (i != -1) {
            int j = html.indexOf('>', i+1); // find the next >
            if (j == -1) return false; // invalid tag, not closed
            String tag = html.substring(i+1, j);
            if(!tag.startsWith("/")) { // it is an opening tag
                stack.push(tag);
            } else { // closing tag
                if(stack.isEmpty()) return false; // found a closing tag before an opening tag
                if(!tag.substring(1).equals(stack.pop())) return false; // mismatch tag
            }
            i = html.indexOf('<', j+1); // find next <
        }
        return stack.isEmpty();
    }

    /**
     *
     * @param queue a group of n people sitting in a circle.
     * @param k every kth person is removed from the circle
     * @return the last one standing in the circle
     */
    static String josephusProblem(Queue<String> queue, int k) {
        if(queue.isEmpty()) return null;
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++)
                queue.enqueue(queue.dequeue()); // rotate
            String removed = queue.dequeue(); // remove the kth person from the circle
            System.out.println("Person " + removed + " is out");
        }
        return queue.dequeue(); // the last one standing
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
        Stack<Integer> stack = new LinkedStack<>();
        for(int asteroid: asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                if (Math.abs(top) > Math.abs(asteroid)) {
                    destroyed = true;
                    break;
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!destroyed)
                stack.push(asteroid);
        }
        int[] finalState = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            finalState[i] = stack.pop();
        }
        return finalState;
    }
}
