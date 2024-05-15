package graphs;

public class Main {
    public static void main(String[] args) {
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
        graph.dfs();
        graph.clockTick();
        graph.stronglyConnectedComponents();
        System.out.println(graph);
        graph.bfs('A');
    }
}
