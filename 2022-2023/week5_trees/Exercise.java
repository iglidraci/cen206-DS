import java.util.*;

public class Exercise {
    // ---- Node definition for a tree -----
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };
    public static void main(String[] args) {
        System.out.println(largestRectangle(new int[]{2, 1, 5, 6, 2, 3}));
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        System.out.println(levelOrder(root));
        System.out.println(postorder(root));
        System.out.println(preorder(root));
        System.out.println(sumOfTree(root));
    }

    static int largestRectangle(int[] histogram) {
        /*
         * Given an array of integers called heights representing the histogram’s bar height
         * where the width of each bar is 1, return the area of the largest rectangle in the histogram.
         * Input: heights = [2,1,5,6,2,3]
         * Output: 10*/
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> heights = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < histogram.length; i++) {
            int start = i;
            while(!heights.isEmpty() && heights.peek() > histogram[i]) {
                int h = heights.pop();
                int p = positions.pop();
                maxArea = Math.max(maxArea, (i - p) * h);
                start = p;
            }
            if(heights.isEmpty() || heights.peek() < histogram[i]) {
                heights.push(histogram[i]);
                positions.push(start);
            }
        }
        while(!heights.isEmpty()) {
            int h = heights.pop();
            int p = positions.pop();
            maxArea = Math.max(maxArea, (histogram.length - p) * h);
        }
        return maxArea;
    }

    static int largestRectangleBad(int[] histogram) {
        int maxArea = 0;
        for(int i = 0; i < histogram.length; i++) {
            int left = i;
            int right = i;
            for(int j=i-1; j >= 0; j--) {
                if(histogram[j] >= histogram[i])
                    left = j;
                else break;
            }
            for(int j=i + 1; j < histogram.length; j ++) {
                if(histogram[j] >= histogram[i])
                    right = j;
                else break;
            }
            maxArea = Math.max((right-left + 1) * histogram[i], maxArea);
        }
        return maxArea;
    }

    static List<Integer> postorder(Node root) {
        /*Given the root of a tree, return the postorder traversal of its nodes' values.*/
        List<Integer> snapshot = new ArrayList<>();
        postorderHelper(root, snapshot);
        return snapshot;
    }

    private static void postorderHelper(Node root, List<Integer> snapshot) {
        for(Node child : root.children)
            postorderHelper(child, snapshot);
        snapshot.add(root.val);
    }

    static List<Integer> preorder(Node root) {
        /*Given the root of a tree, return the preorder traversal of its nodes' values.*/
        List<Integer> snapshot = new ArrayList<>();
        preorderHelper(root, snapshot);
        return snapshot;
    }

    private static void preorderHelper(Node root, List<Integer> snapshot) {
        snapshot.add(root.val);
        for(Node child : root.children)
            preorderHelper(child, snapshot);
    }

    static class Position {
        public Node node;
        public int level;
        public Position(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    static List<List<Integer>> levelOrder(Node root) {
        /*
        * Given a tree, return the level order traversal of its nodes' values.
        * Tree input is represented in their level order traversal, each group of children is separated by the null value
        * Input: root = [1,null,3,2,4,null,5,6]
        * Output: [[1],[3,2,4],[5,6]]
        * */
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Position> q = new ArrayDeque<>();
        var pos = new Position(root, 0);
        q.add(pos);
        while(!q.isEmpty()) {
            var top = q.remove();
            if(levels.size() <= top.level) {
                levels.add(new ArrayList<>());
            }
            levels.get(top.level).add(top.node.val);
            for(Node c : top.node.children) {
                q.add(new Position(c, top.level + 1));
            }
        }
        return levels;
    }

    static int sumOfTree(Node root) {
        if (root == null) return 0;
        int sum = root.val;
        for(Node child : root.children)
            sum += sumOfTree(child);
        return sum;
    }
}
