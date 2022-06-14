public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 1; i<= 9; i++)
            graph.addVertex(i);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 7);
        graph.addEdge(3, 9);
        graph.addEdge(4, 1);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 2);
        graph.addEdge(6, 3);
        graph.addEdge(6, 9);
        graph.addEdge(7, 8);
        graph.addEdge(8, 6);
        graph.dfs();
        graph.connectedComponents();
        graph.clockTick();
        graph.stronglyConnectedComponents();
//        graph.bfs(1);
    }
}
