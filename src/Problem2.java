import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		List<Integer>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			adjList[from].add(to);
		}

		boolean[] visited = new boolean[n];
		return dfs(adjList, source, destination, visited);
	}

	private boolean dfs(List<Integer>[] adjList, int vertex, int destination, boolean[] visited) {
		if (visited[vertex]) {
			return false; // We have found a cycle
		}
		if (adjList[vertex].isEmpty()) {
			return vertex == destination; // Check if this is the destination vertex
		}
		visited[vertex] = true;
		for (int neighbor : adjList[vertex]) {
			if (!dfs(adjList, neighbor, destination, visited)) {
				return false;
			}
		}
		visited[vertex] = false;
		return true;
	}
}
