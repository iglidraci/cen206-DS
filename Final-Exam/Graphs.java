import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graphs {
    public static void main(String[] args) {
        boolean[][] adjMatrix = new boolean[4][4];
        adjMatrix[0][1] = true; // we have an edge from 0 -> 1
        adjMatrix[0][2] = true; // we have an edge from 0 -> 2
        adjMatrix[0][3] = true; // we have an edge from 0 -> 3
        adjMatrix[1][3] = true; // we have an edge from 1 -> 3
        adjMatrix[3][2] = true; // we have an edge from 3 -> 2
        ArrayList<Edge> edgeList = edgeList(adjMatrix);
        System.out.println(edgeList.toString());
        /*
         * let's look at the adjacency list representation of this simple graph
         * It is supposed to be something like this (depending on how you imagine it):
         * 0 : [1, 2, 3]
         * 1 : [3]
         * 3 : [2]
         */
        HashMap<Integer, LinkedList<Integer>> adjList = adjacencyList(edgeList);
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " : ");
            System.out.println(adjList.get(vertex).toString());
        }
    }

    static ArrayList<Edge> edgeList (boolean[][] adjacencyMatrix) {
        // given the adjacency matrix, return the edge list
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j])
                    edges.add(new Edge(i, j));
            }
        }
        return edges;
    }

    static HashMap<Integer, LinkedList<Integer>> adjacencyList (ArrayList<Edge> edgeList) {
        // given the edge list, return the adjacency list
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        for (Edge edge : edgeList) {
            if (!adjList.containsKey(edge.from))
                adjList.put(edge.from, new LinkedList<Integer>());
            adjList.get(edge.from).add(edge.to); // get the linked list associated with this vertex and append the other end of the edge
        }
        return adjList;
    }

    static boolean[][] adjacencyMatrix (ArrayList<Edge> edgeList) {
        // given the edge list, return the adjacency matrix
        // for simplicity, suppose vertices are between [0-3]
        boolean[][] adjMatrix = new boolean[4][4];
        for (Edge edge : edgeList) {
            adjMatrix[edge.from][edge.to] = true;
        }
        return adjMatrix;
    }
}

class Edge {
    int from;
    int to;
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    public String toString() {
        return "(" + from + " -> " + to + ")";
    }
}