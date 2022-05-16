import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nrs = {8, 9, 15, 5, 2, 3, 19, 1, 4, 50, 54, 100, 45, 70};
        for(int nr: nrs)
            bst.insert(nr);
        System.out.println(Arrays.toString(bst.inorder().toArray()));
        bst.delete(2);
        bst.delete(19);
        System.out.println(Arrays.toString(bst.inorder().toArray()));
        bst.delete(8);
        System.out.println(Arrays.toString(bst.inorder().toArray()));
        System.out.println("second smallest value: " + bst.smallestValue(2));
        System.out.println("fourth smallest value: " + bst.smallestValue(4));
        validBST();
        Integer[] preorder = {8,5,1,7,10,12};
        TreeNode root = constructBstFromPreorder(new ArrayList<>(Arrays.asList(preorder)));
        if (root != null) root.print();
        System.out.print("\nAVL: ");
        AVL<Integer> avl = new AVL<>();
        for(int nr: nrs)
            avl.insert(nr);
        avl.printTree();
        System.out.println("\n" + avl);
        AVL<Integer> avl2 = new AVL<>();
        for (int nr: new int[] {40, 20, 10, 25, 30, 23, 50})
            avl2.insert(nr);
        avl2.printTree();
        System.out.println("\n" + avl2);
    }

    private static TreeNode constructBstFromPreorder(ArrayList<Integer> preorder) {
        if (preorder.isEmpty()) return null;
        int rootValue = preorder.get(0);
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();
        for (int val: preorder.subList(1, preorder.size())) {
            if (rootValue > val) smaller.add(val);
            else bigger.add(val);
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = constructBstFromPreorder(smaller);
        root.right = constructBstFromPreorder(bigger);
        return root;
    }

    private static void validBST() {
        TreeNode root = buildBinaryTree();
        boolean isValid = isValidBST(root);
        System.out.println(isValid);
    }

    private static boolean isValidBST(TreeNode root) {
        Stack<Integer> nodes = new Stack<>();
        try {
            inorder(root, nodes);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private static void inorder(TreeNode root, Stack<Integer> nodes) throws Exception {
        if (root == null) return;
        inorder(root.left, nodes);
        if (!nodes.isEmpty() && nodes.peek() >= root.value)
            throw new Exception();
        else nodes.push(root.value);
        inorder(root.right, nodes);
    }

    private static TreeNode buildBinaryTree() {
        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(17);
        root.right = new TreeNode(88);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(32);
        return root;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {this.value = value;}
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void print() {
            inorder(this);
        }

        private void inorder(TreeNode treeNode) {
            if (treeNode == null) return;
            inorder(treeNode.left);
            System.out.print(treeNode.value + " ");
            inorder(treeNode.right);
        }
    }
}
