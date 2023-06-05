import java.util.*;

public class Main {
    public static void main(String[] args) {
        // [3,1,4,3,null,1,5]
        TreeNode root = new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        System.out.println(maxNodes(root));
        TreeNode avl = new TreeNode(22,
                new TreeNode(18,
                        new TreeNode(8, new TreeNode(6), new TreeNode(9)),
                        new TreeNode(21, new TreeNode(20), null)),
                new TreeNode(50,
                        new TreeNode(43),
                        new TreeNode(62, new TreeNode(51), new TreeNode(63))));
        System.out.println(isAVLTree(avl));
        int[] nums = {1,1,1,2,2,3};
        System.out.println("Top 2 most frequent elements: " + Arrays.toString(topKFrequent(nums, 2)));
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(4, trust));
    }

    /**
     * Given a binary tree root, a node X in the tree is named max if in the path from root to X there
     * are no nodes with a value greater than X.
     * Return the number of max nodes in the binary tree.
     */
    static int maxNodes(TreeNode root) {
        return 0;
    }

    /**
     * Given an array of integers preorder, which represents the preorder traversal of a BST,
     * construct the tree and return its root.
     * All the values of preorder are unique.
     */
    static TreeNode bstFromPreorder(int[] preorder) {
        return null;
    }

    /*
    * Given the root of a binary tree, check whether is an AVL tree or not
    * */
    static boolean isAVLTree(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && isBalanced(root);
    }

    static boolean isBalanced(TreeNode root) {
        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private static int height(TreeNode root) {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static boolean isBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     * Example
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     */
    static int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
     * same color are adjacent, with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     */

    static void sortColors(int[] nums) {

    }

    /**
     * You are given the definition of an edge. Knowing that the graph contains vertices from 0 to 9,
     * return the adjacency matrix representation of a list of edges.
     */
    static boolean[][] adjacencyMatrix(ArrayList<Edge> edgeList) {
        return null;
    }
    /**
     * You are given an adjacency list representation of a directed graph.
     * Write a method that will accept a vertex from the graph and will explore all the reachable vertices
     * in depth-first ordering.
     * Exploring means printing the order by which you visit them.
     */
    static void depthFirst(HashMap<Integer, LinkedList<Integer>> graph, int vertex) {

    }

    /*
     In a town, there are n people labeled from 1 to n.
     There is a rumor that one of these people is secretly the town judge.
     If the town judge exists, then:
     1) The town judge trusts nobody.
     2) Everybody (except for the town judge) trusts the town judge.
     There is exactly one person that satisfies properties 1 and 2.
     You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person
     labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

     Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
     -----
     Example 1
     Input: n = 2, trust = [[1,2]]
     Output: 2
     ------
     Example 2
     Input: n = 3, trust = [[1,3],[2,3]]
     Output: 3
     ------
     Example 3
     Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     Output: -1
     --------
     Example 4
     Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     Output: -1
     */
    static int findJudge(int n, int[][] trust) {
        return -1;
    }

}
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
}

class Edge {
    int from; // start vertex of the edge
    int to; // end vertex of the edge
    public Edge (int from, int to) {
        this.from = from;
        this.to = to;
    }
}
