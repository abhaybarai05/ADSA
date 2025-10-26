//Prim's Algorithm in Java
import java.util.*;

public class PrimsAlgorithm {
    static final int INF = 9999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V][V];

        System.out.println("Enter the cost adjacency matrix (0 if no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 0)
                    graph[i][j] = INF; // no edge = infinite cost
            }
        }

        boolean[] selected = new boolean[V];
        selected[0] = true; // start from vertex 0
        int edges = 0, totalCost = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        while (edges < V - 1) {
            int min = INF;
            int x = 0, y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);
            totalCost += graph[x][y];
            selected[y] = true;
            edges++;
        }

        System.out.println("\nTotal cost of Minimum Spanning Tree: " + totalCost);
        sc.close();
    }
}