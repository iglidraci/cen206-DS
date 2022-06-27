import java.util.ArrayList;

public class Tree {
    public static void main(String[] args) {
        /*
         *      5
         *    /  \
         *   2    7
         */
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(7));
        System.out.println(inOrder(root).toString()); // elements are sorted in increasing order, think how to use it
        System.out.println(preOrder(root).toString());
    }
    // in-order
    static ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }
    private static void inOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        // hidden from the outsiders ~ outlanders
        if (root == null) return;
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }
    // pre-order
    static ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraverse(root, list);
        return list;
    }
    private static void preOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        // hidden from the outsiders ~ outlanders
        if (root == null) return;
        list.add(root.val);
        preOrderTraverse(root.left, list);
        preOrderTraverse(root.right, list);
    }

    // post-order
    static ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrderTraverse(root, list);
        return list;
    }
    private static void postOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        // hidden from the outsiders ~ outlanders
        if (root == null) return;
        postOrderTraverse(root.left, list);
        postOrderTraverse(root.right, list);
        list.add(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val) {
        this(val, null, null);
    }
}
