import java.util.Scanner;

public class Lab1 {
    public static void main(String args[]) {
        System.out.print("Enter a number between 0 and 9: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        // The right-most number
        int n = input % 10;
        // Print the graph in Notepad and then converd all the "7" to "%d" for String
        // format

        String output = String.format("      %d        %d        %d     %d      %d\n" +
                "      %d       %d %d        %d   %d      %d %d\n" +
                "%d     %d      %d%d%d%d%d        %d %d      %d%d%d%d%d\n" +
                "  %d %d       %d     %d        %d      %d     %d\n", n, n, n, n, n, n, n, n, n, n, n, n, n, n, n, n, n,
                n, n, n, n, n, n, n, n, n, n, n, n, n, n, n, n);
                
        System.out.println(output);

    }
}
