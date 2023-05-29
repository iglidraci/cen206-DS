import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WeightedGraph<T> {
    private final HashMap<T, HashMap<T, Integer>> adjacencyList = new HashMap<>();
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex))
            adjacencyList.put(vertex, new HashMap<>());
        else throw new IllegalArgumentException("Vertex already in the graph");
    }
    public void addEdge(T a, T b, int weight) {
        if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b))
            throw new IllegalArgumentException("Vertices are not in the graph");
        if (!adjacencyList.get(a).containsKey(b)) {
            adjacencyList.get(a).put(b, weight);
        }
        else throw new IllegalArgumentException("Edge already exists");
    }

    public void naiveShortestPath(T a) {
        HashMap<T, Integer> dist = new HashMap<>();
        HashMap<T, T> prev = new HashMap<>();
        for(T u : adjacencyList.keySet()) {
            dist.put(u, Integer.MAX_VALUE);
            prev.put(u, null);
        }
        dist.put(a, 0);
        boolean change;
        do {
            change = relaxAllEdges(dist, prev);
        } while (change);
        printPaths(a, dist, prev);
    }

    private void printPaths(T a, HashMap<T, Integer> dist, HashMap<T, T> prev) {
        for(T v : dist.keySet()) {
            if(dist.get(v) != Integer.MAX_VALUE) {
                System.out.println("Distance " + a + " -> " + v + " : " + dist.get(v));
                System.out.println("Path " + a + " -> " + v + " : " + reconstructPath(a, v, prev));
                System.out.println("-".repeat(20));
            }
        }
    }

    private ArrayList<T> reconstructPath(T a, T u, HashMap<T, T> prev) {
        ArrayList<T> result = new ArrayList<>();
        while (u != a) {
            result.add(u);
            u = prev.get(u);
        }
        Collections.reverse(result);
        return result;
    }

    private boolean relaxAllEdges(HashMap<T, Integer> dist, HashMap<T, T> prev) {
        boolean change = false;
        for(T u : adjacencyList.keySet()) {
            for(T v : adjacencyList.get(u).keySet()) {
                int w = getWeight(u, v);
                if(dist.get(v) > dist.get(u) + w) {
                    dist.put(v, dist.get(u) + w);
                    prev.put(v, u);
                    change = true;
                }
            }
        }
        return change;
    }

    private int getWeight(T u, T v) {
        return adjacencyList.get(u).get(v);
    }

    public void Dijkstra(T a) {
        HashMap<T, Integer> dist = new HashMap<>();
        HashMap<T, T> prev = new HashMap<>();
        for(T u : adjacencyList.keySet()) {
            dist.put(u, Integer.MAX_VALUE);
            prev.put(u, null);
        }
        dist.put(a, 0);
        HashMap<T, Integer> priorityQueue;
        priorityQueue = (HashMap<T, Integer>) dist.clone();
        while (!priorityQueue.isEmpty()) {
            T u = extractMin(priorityQueue);
            for(T v : adjacencyList.get(u).keySet()) {
                int w = getWeight(u, v);
                if(dist.get(v) > dist.get(u) + w) {
                    dist.put(v, dist.get(u) + w);
                    prev.put(v, u);
                    priorityQueue.put(v, dist.get(v));
                }
            }
        }
        printPaths(a, dist, prev);
    }

    private T extractMin(HashMap<T, Integer> priorityQueue) {
        T vertex = null;
        int min = Integer.MAX_VALUE;
        for(T v : priorityQueue.keySet()) {
            if(priorityQueue.get(v) < min) {
                min = priorityQueue.get(v);
                vertex = v;
            }
        }
        priorityQueue.remove(vertex);
        return vertex;
    }
}
