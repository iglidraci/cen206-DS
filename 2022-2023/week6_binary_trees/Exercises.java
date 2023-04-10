public class Exercises {
    // definition for Binary Tree Node
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
        System.out.println(represent(root));
        System.out.println("Nr nodes: " + countNodes(root));
        invertTree(root);
        System.out.println(represent(root));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(10)), new TreeNode(3, new TreeNode(5), new TreeNode(8)));
        System.out.println(isSameTree(root, root2));
        TreeNode bst = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                                            new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(search(bst, 9));
        System.out.println(search(bst, 10));
        System.out.println("min " + minimum(bst));
        System.out.println("max " + maximum(bst));
        TreeNode bst2 = new TreeNode(10);
        bstInsert(bst2, 5);
        bstInsert(bst2, 2);
        bstInsert(bst2, 1);
        bstInsert(bst2, 4);
        bstInsert(bst2, 7);
        bstInsert(bst2, 9);
        bstInsert(bst2, 8);
        bstInsert(bst2, 11);
        bstInsert(bst2, 13);
        bstInsert(bst2, 12);
        System.out.println(represent(bst2));
        System.out.println("Valid BST? " + isValidBST(root));
        System.out.println("Valid BST? " + isValidBST(bst));
    }

    static int countNodes(TreeNode root) {
        /*Given the root of a binary tree, return the number of nodes*/
        return 0;
    }

    static void invertTree(TreeNode root) {
        /*
        Given the root of a binary tree.
        Input: root = [2,1,3]
        Output: [2,3,1]
        --------
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]
        */
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

    static TreeNode search(TreeNode root, int key) {
        /*
        Given the root of a BST, return the Node holding the given key
        Return null if key not in the BST
         */
        return null;
    }

    static TreeNode minimum(TreeNode root) {
        /*
        Given the root of a BST, return the node holding the minimum value
         */
        return null;
    }

    static TreeNode maximum(TreeNode root) {
        /*
        Given the root of a BST, return the node holding the maximum value
         */
        return null;
    }
    static void bstInsert(TreeNode root, int key) {
        /*Given the root of a BST, insert a new value into it*/
    }

    static boolean isValidBST(TreeNode root) {
        /*Given the root of a binary tree, determine if it is a BST.*/
        return false;
    }

    /**Methods to print a binary tree. Don't change them, don't bother to read them.
     * Just call represent(root) to get a string representation of your binary tree
     * Colors will work only for Unix shell prompts. Fix them for Windows.
     * */
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

    static String represent(TreeNode root) {
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

    public static final String YELLOW_COLOR = "\u001B[33m";
    public static final String BLUE_COLOR = "\u001B[34m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String RED_COLOR = "\033[1;31m";

}


