import java.util.Scanner;

public class LCS {

    // Function to find the length of the Longest Common Subsequence
    public static int lcs(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Building the dp table in a bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Print the reconstructed LCS string
        printLCS(str1, str2, m, n, dp);
        
        // Return the length of the LCS
        return dp[m][n];
    }
    
    // Function to reconstruct and print the LCS string
    private static void printLCS(String str1, String str2, int m, int n, int[][] dp) {
        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[index - 1] = str1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.print("Longest Common Subsequence: ");
        for (char c : lcs) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();
        
        int m = str1.length();
        int n = str2.length();
        
        int length = lcs(str1, str2, m, n);
        System.out.println("Length of the LCS is: " + length);
        
        scanner.close();
    }
}