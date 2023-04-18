import java.util.Stack;

public class Exercises {
    public static void main(String[] args) {
        System.out.println(upper("HeLLoW0R1d"));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 1));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(listString(head));
        System.out.println(listString(popMiddle(head)));
        System.out.println(isValid("[(5+x)−(y+z)]"));
        TreeNode root = new TreeNode(1, new TreeNode(5, new TreeNode(7), new TreeNode(9)), new TreeNode(3, new TreeNode(5), new TreeNode(9)));
        System.out.println(oddValues(root));
        System.out.println(height(root));
        System.out.println(isBST(root));
        root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                                    new TreeNode(7, new TreeNode(6), new TreeNode(8, null, new TreeNode(10))));
        System.out.println(isBST(root));
    }
    static int upper(String str) {
        /*
        Return the number of uppercase alphabetical characters (A-Z)
        Input: HeLLoW0R1d
        Output: 5
         */
        int count = 0;
        for(char c : str.toCharArray())
            if(c >= 'A' && c <= 'Z') count++;
        return count;
    }

    static int binarySearch(int[] arr, int target) {
        /*
        * Given a sorted array, write a recursive solution to return the position of the given target
        * If target is not located in the array, return -1
        * */
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    static int binarySearch(int[] arr, int target, int left, int right) {
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return binarySearch(arr, target, left, mid - 1);
        else return binarySearch(arr, target, mid + 1, right);
    }

    static String listString(ListNode head) {
        /*
        * Return a string that concatenates all the values in the linked list
        * using arrow (->) as a delimiter. The tail should point next to string 'NIL'*/
        if(head == null) return "NIL";
        return head.val + " -> " + listString(head.next);
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
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
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
        Stack<Character> stack = new Stack<>();
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

    static int height(TreeNode node) {
        /*
        * Given a node in a binary tree, determine its height*/
        int h = 0;
        if (node.left != null)
            h = 1 + height(node.left);
        if(node.right != null)
            h = Math.max(h, 1 + height(node.right));
        return h;
    }

    static int oddValues(TreeNode root) {
        /*
         * Given the root of a binary tree, return the total number of odd valued nodes
         * */
        if(root != null) {
            int c = 0;
            if(root.val % 2 != 0)
                c++;
            return c + oddValues(root.left) + oddValues(root.right);
        }
        return 0;
    }

    static boolean isBST(TreeNode root) {
        /*
        * Given the root of a binary tree, determine if the properties of a BST hold.
        * */
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
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
