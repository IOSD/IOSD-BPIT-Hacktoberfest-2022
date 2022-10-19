#include <iostream>
#include <limits.h>
using namespace std;

// Number of vertices in the graph
#define V 9

// Function to find the vertex with minimum distance value, 
// from the set of vertices not yet included in shortest path tree
int minDistance(int dist[], bool sptSet[])
{
	int min = INT_MAX, min_index;
	for (int v = 0; v < V; v++)
	{
		if (sptSet[v] == false && dist[v] <= min)
		{
			min = dist[v], min_index = v;
		}
	}
	return min_index;
}

// Function to print the constructed distance array
void printSolution(int dist[])
{
	cout << "Vertex \t Distance from Source" << endl;
	for (int i = 0; i < V; i++)
	{
		cout << i << " \t\t\t\t" << dist[i] << endl;
	}
}

// Function that implements Dijkstra's single source shortest path algorithm
// for a graph represented using adjacency matrix representation
void dijkstra(int graph[V][V], int src)
{
    // The output array. dist[i] will hold the shortest distance from src to i
	int dist[V];

    // sptSet[i] will be true if vertex i is included in shortest
	// path tree or shortest distance from src to i is finalized 
	bool sptSet[V];

	// Initialize all distances as INFINITE and stpSet[] as false
	for (int i = 0; i < V; i++)
		dist[i] = INT_MAX, sptSet[i] = false;

	// Distance of source vertex from itself is always 0
	dist[src] = 0;

	// Find shortest path for all vertices
	for (int count = 0; count < V - 1; count++) {
		// Choose the minimum distance vertex from the set of vertices not yet processed.
		// u is always equal to src in the first iteration.
		int u = minDistance(dist, sptSet);

		// Mark the chosen vertex as processed
		sptSet[u] = true;

		// Update dist value of the adjacent vertices of the chosen vertex.
		for (int v = 0; v < V; v++)
		{
			// Update dist[v] only if is not in sptSet, there is an edge from u to v, and total
			// weight of path from src to v through u is smaller than current value of dist[v]
			if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
			{
				dist[v] = dist[u] + graph[u][v];
			}
		}
	}

	// print the constructed distance array
	printSolution(dist);
}

// driver's code
int main()
{

	// Example of a graph in the form of adjacency matrix
	int graph[V][V] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
						{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
						{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
						{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
						{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
						{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
						{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
						{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
						{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

	// Dijkstra Function call 
	dijkstra(graph, 0);

	return 0;
}
