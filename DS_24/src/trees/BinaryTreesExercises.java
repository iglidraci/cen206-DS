package trees;

import linear_structures.ArrayQueue;
import linear_structures.Queue;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreesExercises {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(10)), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        System.out.println(treeString(root));
        System.out.println(sumOfLeftLeaves(root));
        System.out.println(breadthFirstTraversing(root));
    }

    static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null && isLeaf(root.left))
            sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    static void invert(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invert(root.left);
            invert(root.right);
        }

    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        /*
        Given the roots of two binary trees p and q, write a function to check if they are the same or not.
        Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
        Input: p = [1,2,3], q = [1,2,3]
        Output: true
        ------
        Input: p = [1,2], q = [1,null,2]
        Output: false
         */
        if(p == null && q == null)
            return true;
        if(p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    static int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    static int sumRootToLeaf(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = 10*sum + root.val;
        if(isLeaf(root)) return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }

    static ArrayList<Integer> breadthFirstTraversing(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayQueue<>(); // max capacity 1000
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode node = q.dequeue();
            list.add(node.val);
            if(node.left != null) q.enqueue(node.left);
            if(node.right != null) q.enqueue(node.right);
        }
        return list;
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static boolean isValidBST(TreeNode root) {
        /*Given the root of a binary tree, determine if it is a BST.*/
        Stack<Integer> stack = new Stack<>();
        return isValid(root, stack);
    }

    static boolean isValid(TreeNode root, Stack<Integer> stack) {
        if(root == null) return true;
        boolean b = isValid(root.left, stack);
        if(!stack.isEmpty() && stack.peek() >= root.val) return false;
        stack.push(root.val);
        b = b && isValid(root.right, stack);
        return b;
    }

    /**Methods to print a binary tree. Don't change them, don't bother to read them.
     * Just call treeString(root) to get a string representation of your binary tree
     * Colors will work only for Unix shell prompts. Fix them for Windows.
     * */
    static String treeString(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(RED_COLOR).append(root.val).append(RESET_COLOR);

        String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
        String pointerLeft = (root.right != null) ? "L├──>" : "L└──>";
        pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    static void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append(" │  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
            String pointerLeft = (node.right != null) ? "L├──>" : "L└──>";
            pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    public static final String YELLOW_COLOR = "\u001B[33m";
    public static final String BLUE_COLOR = "\u001B[34m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String RED_COLOR = "\033[1;31m";
}
