package graphs;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<Character> graph = getWeightedGraph();
        graph.Dijkstra('s');

        Graph<Character> graph2 = getCharacterGraph();
        graph2.BFS('A');
    }

    private static Graph<Character> getCharacterGraph() {
        Graph<Character> graph = new Graph<>(true);
        for (int i = 0; i< 9; i++)
            graph.addVertex((char) ('A' + i));
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'F');
        graph.addEdge('C', 'B');
        graph.addEdge('E', 'C');
        graph.addEdge('E', 'A');
        graph.addEdge('E', 'H');
        graph.addEdge('D', 'A');
        graph.addEdge('D', 'G');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.addEdge('I', 'H');
        graph.addEdge('I', 'F');
        return graph;
    }

    private static WeightedGraph<Character> getWeightedGraph() {
        WeightedGraph<Character> graph = new WeightedGraph<>();
        graph.addVertex('s');
        graph.addVertex('t');
        graph.addVertex('y');
        graph.addVertex('x');
        graph.addVertex('z');
        graph.addEdge('s', 't', 10);
        graph.addEdge('s', 'y', 5);
        graph.addEdge('t', 'y', 2);
        graph.addEdge('t', 'x', 1);
        graph.addEdge('y', 'x', 9);
        graph.addEdge('y', 't', 3);
        graph.addEdge('y', 'z', 2);
        graph.addEdge('z', 'x', 6);
        graph.addEdge('z', 's', 7);
        graph.addEdge('x', 'z', 4);
        return graph;
    }
}
