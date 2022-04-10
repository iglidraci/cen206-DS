import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new LinkedStack<>();
        Stack<Integer> stack2 = new ArrayStack<>();
        Stack<Integer> stack3 = new QueueStack<>();
        testStack(stack1);
        testStack(stack2);
        testStack(stack3);
        String expression = "[(5+x)−(y+z)]";
        System.out.println(expression + " is " + (isMatching(expression) ? "" : " not ") + " correct");
        String html = "<body><h1>Hello world</h1><p>Hello universe</p></body>";
        System.out.println(html + " is " + (isHtmlMatching(html) ? "" : " not ") + " correct");
        int[] histogram = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangle(histogram);
        System.out.println("Largest area in histogram " + Arrays.toString(histogram) + " is " + maxArea);
        int[] asteroids = {-5,-10, 10, -5, 10, 5};
        int[] stateOfAsteroids = asteroidCollision(asteroids);
        System.out.println("Final state of asteroids " + Arrays.toString(asteroids) + " -> " + Arrays.toString(stateOfAsteroids));
        testBrowserHistory();
    }

    private static void testBrowserHistory() {
        String homepage = "leetcode.com";
        String[] commands = {"visit","visit","visit","back","back","forward","visit","forward","back","back"};
        String[] urls = {"google.com","facebook.com","youtube.com","1","1","1","linkedin.com","2","2","7"};
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        ArrayList<String> states = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            switch (commands[i]) {
                case "visit" -> {
                    states.add(browserHistory.toString());
                    browserHistory.visit(urls[i]);
                }
                case "back" -> states.add(browserHistory.back(Integer.parseInt(urls[i])));
                case "forward" -> states.add(browserHistory.forward(Integer.parseInt(urls[i])));
            }
        }
        for (String state: states)
            System.out.print(state + ", ");
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new LinkedStack<>();
        for(int asteroid: asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && willCollide(stack.peek(), asteroid)) {
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

    private static boolean willCollide(int left, int right) {
        return left > 0 && right < 0;
    }

    private static int largestRectangle(int[] histogram) {
        int maxArea = 0;
        // keep a stack of int[2] where first element will be the index and second element will be the height
        Stack<int[]> stack = new QueueStack<>();
        for (int i = 0; i < histogram.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > histogram[i]) {
                int[] popped = stack.pop();
                int index = popped[0];
                int height = popped[1];
                maxArea = Math.max(maxArea, (i-index) * height);
                start = index;
            }
            stack.push(new int[] {start, histogram[i]});
        }
        // check the rest of the elements in the stack
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            int index = popped[0];
            int height = popped[1];
            maxArea = Math.max(maxArea, (histogram.length - index) * height);
        }
        return maxArea;
    }

    private static boolean isMatching(String expression) {
        Stack<Character> stack = new LinkedStack<>();
        for (char c: expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char popped = stack.pop();
                if ((c == ')' && popped != '(') || (c == '}' && popped != '{') || (c == ']' && popped != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static void testStack(Stack<Integer> stack) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.peek() == 3;
        assert stack.pop() == 3;
        assert stack.peek() == 2;
        stack.push(3);
        System.out.println(stack);
    }

    private static boolean isHtmlMatching(String html) {
        Stack<String> stack = new LinkedStack<>();
        int i = html.indexOf('<'); // find the first < opening tag
        while (i != -1) {
            int j = html.indexOf('>', i+1); // find the next closing tag >
            if (j == -1) return false;
            String tag = html.substring(i+1, j); // get only the tag name, remove < and >
            if (tag.charAt(0) != '/') // it means that this is an opening tag
                stack.push(tag);
            else { // let's deal with a closing tag
                if (stack.isEmpty()) return false;
                if (!tag.substring(1).equals(stack.pop())) return false; // get substring of closing tag from index 1
            }
            i = html.indexOf('<', j+1); // find the next first < after the closing tag >
        }
        return stack.isEmpty();
    }
}
