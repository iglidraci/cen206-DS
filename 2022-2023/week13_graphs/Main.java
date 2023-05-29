public class Main {
    public static void main(String[] args) {
//        Graph<Character> graph = new Graph<>(true);
//        for (int i = 0; i <= 'I' - 'A'; i++) {
//            graph.addVertex((char)('A' + i));
//        }
//        graph.addVertex('Z');
//        graph.addVertex('Y');
//        graph.addEdge('A', 'B');
//        graph.addEdge('B', 'E');
//        graph.addEdge('B', 'F');
//        graph.addEdge('C', 'B');
//        graph.addEdge('D', 'A');
//        graph.addEdge('D', 'G');
//        graph.addEdge('E', 'A');
//        graph.addEdge('E', 'C');
//        graph.addEdge('E', 'H');
//        graph.addEdge('G', 'H');
//        graph.addEdge('H', 'I');
//        graph.addEdge('I', 'H');
//        graph.addEdge('Z', 'Y');
//        graph.addEdge('Y', 'Z');
//        graph.dfs();
////        graph.connectedComponents();
////        graph.clockTick();
//        graph.stronglyConnectedComponents();
//        graph.bfs('A');
//        System.out.println(graph.shortestPath('A', 'I'));
        WeightedGraph<Character> cities = new WeightedGraph<>();
        for (int i = 0; i <= 'F' - 'A'; i++) {
            cities.addVertex((char)('A' + i));
        }
        cities.addEdge('A', 'B', 3);
        cities.addEdge('A', 'C', 10);
        cities.addEdge('B','C', 8);
        cities.addEdge('B','D', 3);
        cities.addEdge('B','E', 5);
        cities.addEdge('C', 'B', 2);
        cities.addEdge('C', 'E', 5);
        cities.addEdge('D', 'C', 3);
        cities.addEdge('D', 'E', 1);
        cities.addEdge('D', 'F', 2);
        cities.addEdge('E', 'F', 0);
        cities.Dijkstra('A');
    }
}
