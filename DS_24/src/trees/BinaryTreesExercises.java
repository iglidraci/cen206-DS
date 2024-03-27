package trees;

import java.util.ArrayList;

public class BinaryTreesExercises {
    /*Definition for TreeNode*/
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(10)), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        System.out.println(treeString(root));
    }

    static int sumOfLeftLeaves(TreeNode root) {
        return 0;
    }

    static TreeNode invertTree(TreeNode root) {
        return null;
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
        return false;
    }

    static boolean isSymmetric(TreeNode root) {
        return false;
    }

    static int sumRootToLeaf(TreeNode root) {
        return 0;
    }

    static ArrayList<Integer> breadthFirstTraversing(TreeNode root) {
        return null;
    }

    static boolean isValidBST(TreeNode root) {
        /*Given the root of a binary tree, determine if it is a BST.*/
        return false;
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
