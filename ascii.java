import java.util.Scanner;

public class ascii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;

        System.out.println("Enter the character:");
        String input = sc.next(); 
        ch = input.charAt(0);     

        System.out.printf("Ascii value of ch '%c' is '%d'%n", ch, (int) ch);

        sc.close();
    }
}