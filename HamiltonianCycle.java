// Hamiltonian Cycle in Java
import java.util.*;

public class HamiltonianCycle {
    static int V; // number of vertices

    // Check if vertex v can be added at position pos
    static boolean isSafe(int v, int graph[][], int path[], int pos) {
        // Check if adjacent to previous vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if already included
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    // Recursive utility function
    static boolean hamiltonianUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            // If last vertex is connected to first
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamiltonianUtil(graph, path, pos + 1))
                    return true;
                path[pos] = -1; // backtrack
            }
        }
        return false;
    }

    static void hamiltonianCycle(int graph[][]) {
        int path[] = new int[V];
        Arrays.fill(path, -1);
        path[0] = 0; // start from vertex 0

        if (hamiltonianUtil(graph, path, 1)) {
            System.out.println("Hamiltonian Cycle exists:");
            for (int i = 0; i < V; i++)
                System.out.print(path[i] + " ");
            System.out.println(path[0]); // return to start
        } else {
            System.out.println("No Hamiltonian Cycle exists");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();
        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix (0/1):");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        hamiltonianCycle(graph);

        sc.close();
    }
}