import java.util.Scanner;

public class FloydWarshallAlgorithm
{
    static final int MAX = 100;
    static final int INF = 99999; // A large value to represent infinity

    // Function to print the distance matrix
    static void printSolution(int[][] dist, int V)
    {
        System.out.println("\nShortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if (dist[i][j] == INF)
                    System.out.printf("%7s", "INF"); // No path
                else
                    System.out.printf("%7d", dist[i][j]);
            }
            System.out.println();
        }
    }

    // Function to implement Floyd-Warshall Algorithm
    static void floydWarshall(int[][] graph, int V)
    {
        int[][] dist = new int[V][V];

        // Initialize the solution matrix same as input graph
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }

        // Update dist[][] for each intermediate vertex k
        for (int k = 0; k < V; k++)
        {
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from i to j
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the final solution
        printSolution(dist, V);
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter the adjacency matrix (use " + INF + " for INF where there is no edge):");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        floydWarshall(graph, V);

        sc.close();
    }
}