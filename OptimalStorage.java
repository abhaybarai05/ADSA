// Optimal Storage on Tape in Java
import java.util.*;

public class OptimalStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();
        int[] length = new int[n];

        System.out.println("Enter lengths of programs:");
        for (int i = 0; i < n; i++)
            length[i] = sc.nextInt();

        // Sort program lengths in ascending order
        Arrays.sort(length);

        int totalTime = 0, sum = 0;
        System.out.println("\nProgram\tLength\tRetrieval Time");
        for (int i = 0; i < n; i++) {
            sum += length[i];
            totalTime += sum;
            System.out.println((i + 1) + "\t" + length[i] + "\t" + sum);
        }

        double avgRetrieval = (double) totalTime / n;
        System.out.println("\nTotal Retrieval Time: " + totalTime);
        System.out.println("Average Retrieval Time: " + avgRetrieval);

        sc.close();
    }
}