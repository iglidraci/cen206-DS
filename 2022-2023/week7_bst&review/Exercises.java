public class Exercises {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(head);
    }
    static int upper(String str) {
        /*
        Return the number of uppercase alphabetical characters (A-Z)
        Input: HeLLoW0R1d
        Output: 5
         */
        return 0;
    }

    static int binarySearch(int[] arr, int target) {
        /*
        * Given a sorted array, write a recursive solution to return the position of the given target
        * If target is not located in the array, return -1
        * */
        return -1;
    }

    static String listString(ListNode head) {
        /*
        * Return a string that concatenates all the values in the linked list
        * using arrow (->) as a delimiter. The tail should point next to string 'NIL'*/
        return null;
    }

    static ListNode popMiddle(ListNode head) {
        /*
        * Delete the middle node, and return the head of the modified linked list
        * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing.
        * ---------------
        * Input: head = [1,3,4,7,1,2,6]
        * Output: [1,3,4,1,2,6]
        * ---------------
        * Input: head = [1,2,3,4]
        * Output: [1,2,4]
        * */
        return null;
    }

    static boolean isValid(String expression) {
        /*
        * Given an arithmetic expression containing parentheses, braces, and brackets,
        * return true if all opening symbols correspond to their closing symbols, otherwise false.
        * ------------
        * Input: [(5+x)−(y+z)]
        * Output: true
        * ------------
        * Input: [(5+x)-y+z)]
        * Output: false
        * */
        return false;
    }

    static int height(TreeNode node) {
        /*
        * Given a node in a binary tree, determine its height*/
        return 0;
    }

    static int oddValues(TreeNode root) {
        /*
         * Given the root of a binary tree, return the total number of odd valued nodes*/
        return 0;
    }

    static boolean isBST(TreeNode root) {
        /*
        * Given the root of a binary tree, determine if the properties of a BST hold.
        * */
        return false;
    }

}


/**Definition for Binary Tree Nodes*/
class TreeNode {
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

/**Definition for Singly Linked List Nodes*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
