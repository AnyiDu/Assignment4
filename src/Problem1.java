import java.util.ArrayList;
import java.util.List;

public class Problem1 {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		// Create an adjacency list to represent the graph
		List<Integer>[] adjList = new List[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adjList[u].add(v);
			adjList[v].add(u);
		}

		// Initialize a visited array to keep track of the visited vertices
		boolean[] visited = new boolean[n];

		// Perform DFS starting from the source vertex
		return dfs(adjList, visited, source, destination);
	}

	private boolean dfs(List<Integer>[] adjList, boolean[] visited, int curr, int dest) {
		if (curr == dest) {
			// We have reached the destination vertex
			return true;
		}

		visited[curr] = true;
		for (int neighbor : adjList[curr]) {
			if (!visited[neighbor]) {
				if (dfs(adjList, visited, neighbor, dest)) {
					// A path from neighbor to dest was found
					return true;
				}
			}
		}

		// No path was found from curr to dest
		return false;
	}
}
