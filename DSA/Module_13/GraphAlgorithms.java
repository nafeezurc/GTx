import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> q = new LinkedList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
        List<Vertex<T>> res = new ArrayList<>();
        res.add(start);
        visited.add(start);
        q.add(start);
        while(!q.isEmpty()) {
            Vertex<T> v = q.poll();
            List<VertexDistance<T>> adjVertices = adjList.get(v);
            for(VertexDistance<T> vD : adjVertices) {
                Vertex<T> adj = vD.getVertex();
                if(!visited.contains(adj)) {
                    visited.add(adj);
                    res.add(adj);
                    q.add(adj);
                }
            }
        }
        return res;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        List<Vertex<T>> res = new ArrayList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
        dfs(start, visited, res, adjList);
        return res;
    }

    private static <T> void dfs(Vertex<T> start, Set<Vertex<T>> visited, List<Vertex<T>> res, Map<Vertex<T>, List<VertexDistance<T>>> adjList) {
        res.add(start);
        visited.add(start);
        List<VertexDistance<T>> adjVertices = adjList.get(start);
        for(VertexDistance<T> vD : adjVertices) {
            Vertex<T> adj = vD.getVertex();
            if(!visited.contains(adj)) {
                dfs(adj, visited, res, adjList);
            }
        }
    }
}