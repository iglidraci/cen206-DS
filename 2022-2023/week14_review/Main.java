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
        return countMaxNodes(root, Integer.MIN_VALUE);
    }

    private static int countMaxNodes(TreeNode root, int maxPred) {
        int c = 0;
        if(root == null) return c;
        if(root.val >= maxPred) c++;
        int newMax = Math.max(root.val, maxPred);
        c += countMaxNodes(root.left, newMax);
        c += countMaxNodes(root.right, newMax);
        return c;
    }

    /**
     * Given an array of integers preorder, which represents the preorder traversal of a BST,
     * construct the tree and return its root.
     * All the values of preorder are unique.
     */
    static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i < preorder.length; i++) {
            insertBST(root, preorder[i]);
        }
        return root;
    }

    private static void insertBST(TreeNode root, int val) {
        if(root.val > val) {
            if(root.left == null)
                root.left = new TreeNode(val);
            else
                insertBST(root.left, val);
        } else {
            if(root.right == null)
                root.right = new TreeNode(val);
            else
                insertBST(root.right, val);
        }
    }

    /*
     * Given the root of a binary tree, check whether is an AVL tree or not
     * */
    static boolean isAVLTree(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && isBalanced(root);
    }

    static boolean isBalanced(TreeNode root) {
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int nr : map.keySet()) {
            int frequency = map.get(nr);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(nr);
        }
        int[] topFrequent = new int[k];
        int i = bucket.length - 1;
        int j = 0;
        while (k > 0 && i >=0) {
            if(bucket[i] != null) {
                for(int nr : bucket[i])
                    topFrequent[j++] = nr;
                k = k - bucket[i].size();
            }
            i--;
        }
        return topFrequent;
    }

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
     * same color are adjacent, with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     */

    static void sortColors(int[] nums) {
        int[] freqs = new int[3];
        for (int num : nums) {
            freqs[num]++;
        }
        int k = 0;
        for(int i=0; i < 3; i++) {
            for(int j=1; j <= freqs[i]; j++)
                nums[k++] = i;
        }
    }

    /**
     * You are given the definition of an edge. Knowing that the graph contains vertices from 0 to 9,
     * return the adjacency matrix representation of a list of edges.
     */
    static boolean[][] adjacencyMatrix(ArrayList<Edge> edgeList) {
        boolean[][] graph = new boolean[10][10];
        for(Edge edge : edgeList) {
            graph[edge.from][edge.to] = true;
        }
        return graph;
    }
    /**
     * You are given an adjacency list representation of a directed graph.
     * Write a method that will accept a vertex from the graph and will explore all the reachable vertices
     * in depth-first ordering.
     * Exploring means printing the order by which you visit them.
     */
    static void depthFirst(HashMap<Integer, LinkedList<Integer>> graph, int vertex) {
        HashSet<Integer> visited = new HashSet<>();
        System.out.print("DFS order: ");
        explore(graph, vertex, visited);
        System.out.println();
    }

    private static void explore(HashMap<Integer, LinkedList<Integer>> graph, int vertex, HashSet<Integer> visited) {
        visited.add(vertex); // same as v.visited = True
        System.out.print(vertex + " ");
        for(int neighbor: graph.get(vertex))
            if (!visited.contains(neighbor))
                explore(graph, neighbor, visited);
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
        HashSet<Integer> trusters = new HashSet<>();
        for(int i = 0; i < trust.length; i++) {
            trusters.add(trust[i][0]);
        }
        int potJudge = -1;
        for(int i = 1; i <= n; i++) {
            if(!trusters.contains(i)) {
                potJudge = i;
                break;
            }
        }
        if(potJudge == -1) return -1;
        HashSet<Integer> whoTrustsJudge = new HashSet<>();
        for(int i = 0; i < trust.length; i++) {
            if(trust[i][1] == potJudge)
                whoTrustsJudge.add(trust[i][0]);
        }
        return (whoTrustsJudge.size() == n-1) ? potJudge : -1;
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
