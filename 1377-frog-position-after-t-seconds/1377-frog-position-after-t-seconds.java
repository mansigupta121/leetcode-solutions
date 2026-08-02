import java.util.*;

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        return dfs(graph, visited, 1, target, t, 1.0);
    }

    private double dfs(List<List<Integer>> graph, boolean[] visited, int current, int target, int time, double prob) {
        visited[current] = true;

        // Count unvisited neighbors (children)
        int unvisitedNeighbors = 0;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                unvisitedNeighbors++;
            }
        }

        // Base case: We reached the target node
        if (current == target) {
            // Frog stays on target if time runs out, OR if target is a leaf (can't move anywhere)
            if (time == 0 || unvisitedNeighbors == 0) {
                return prob;
            }
            return 0.0;
        }

        // If time runs out before reaching the target
        if (time == 0) {
            return 0.0;
        }

        // Search deeper into children
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                double result = dfs(graph, visited, neighbor, target, time - 1, prob / unvisitedNeighbors);
                if (result > 0) {
                    return result; // Found target in this subtree
                }
            }
        }

        return 0.0;
    }
}