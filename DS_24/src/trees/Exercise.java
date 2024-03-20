package trees;

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
