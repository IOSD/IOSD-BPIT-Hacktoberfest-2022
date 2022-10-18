#include <bits/stdc++.h>
using namespace std;

// Number of vertices in the graph
#define V 4

// This value will be used for vertices that are not connected to each other 
#define INF 999999

//Function to print the solution matrix
void printSolution(int dist[][V]);

// Solves the all-pairs shortest path problem using Floyd Warshall algorithm
void floydWarshall(int graph[][V])
{
	// dist[][] will be the output matrix that will finally 
    // have the shortest distances between every pair of vertices 
	int dist[V][V], i, j, k;

	// Initialize the solution matrix same as input graph matrix.
	for (i = 0; i < V; i++)
    {
		for (j = 0; j < V; j++)
        {
			dist[i][j] = graph[i][j];
        }
    }

	// Add all vertices one by one to the set of intermediate vertices.
	for (k = 0; k < V; k++) {
		for (i = 0; i < V; i++) {
			for (j = 0; j < V; j++) {
				if (dist[i][j] > (dist[i][k] + dist[k][j]) && (dist[k][j] != INF && dist[i][k] != INF))
                {
					dist[i][j] = dist[i][k] + dist[k][j];
                }
			}
		}
	}

	// Print the shortest distance matrix
	printSolution(dist);
}

// A function to print solution 
void printSolution(int dist[][V])
{
	cout << "The following matrix shows the shortest "
			"distances"
			" between every pair of vertices \n";
	for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
			if (dist[i][j] == INF)
				cout << "INF"
					<< "	 ";
			else
				cout << dist[i][j] << "	 ";
		}
		cout << endl;
	}
}

// Driver's code
int main()
{
    // Example of a graph in the form of adjacency matrix
	int graph[V][V] = { { 0, 5, INF, 10 },
						{ INF, 0, 3, INF },
						{ INF, INF, 0, 1 },
						{ INF, INF, INF, 0 } };

	// Function call
	floydWarshall(graph);
	return 0;
}