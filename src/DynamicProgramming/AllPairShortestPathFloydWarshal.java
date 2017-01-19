package DynamicProgramming;

// Code is not right.
public class AllPairShortestPathFloydWarshal {

	final static int INF = 99999, V = 4;
	int[][] dist = new int[V][V];
	int predecessor[][] = new int[V][V];
	
	void floydWarshall(int graph[][]) {
		int i, j, k;

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can
		 * say the initial values of shortest distances are based on shortest
		 * paths considering no intermediate vertex.
		 */
		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++){
				dist[i][j] = graph[i][j];
				predecessor[i][j] = INF;
			}

		/*
		 * Add all vertices one by one to the set of intermediate vertices. --->
		 * Before start of a iteration, we have shortest distances between all
		 * pairs of vertices such that the shortest distances consider only the
		 * vertices in set {0, 1, 2, .. k-1} as intermediate vertices. ---->
		 * After the end of a iteration, vertex no. k is added to the set of
		 * intermediate vertices and the set becomes {0, 1, 2, .. k}
		 */
		for (k = 0; k < V; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < V; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						predecessor[i][j] = k;
					}
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(dist);
	}
	
	void path(int x, int y) {
		if (predecessor[x][y] == INF)
			System.out.println("x: " + x + " y: " + y);
		else {
			path(x, predecessor[x][y]);
			path(predecessor[x][y], y);
		}
	}

	void printSolution(int dist[][]) {
		System.out.println("Following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	// Driver program to test above function
	public static void main(String[] args) {
		/*
		 * Let us create the following weighted graph 10 (0)------->(3) | /|\ 5
		 * | | | | 1 \|/ | (1)------->(2) 3
		 */
		int graph[][] = { { 0, 3, 8, INF, -4 }, { INF, 0, INF, 1, 7 }, { INF, 4, 0, INF, INF }, { 2, INF, -5, 0, INF }, { INF, INF, INF, 6, 0} };
		AllPairShortestPathFloydWarshal a = new AllPairShortestPathFloydWarshal();

		// Print the solution
		a.floydWarshall(graph);
		a.path(3, 1);
	}
}