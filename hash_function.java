import java.util.Scanner;

public class hash_function {

    public static int asciivalue(String input, int tablesize) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sum += (int) c;
        }

        return sum % tablesize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the table size :");
        int tablesize = sc.nextInt();
        sc.nextLine(); 


        while (true) {
            System.out.print("Enter String: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break; 
            }
            int hashvalue = asciivalue(input, tablesize);
            System.out.println("Table index: " + hashvalue);
        }

        sc.close();
    }
}