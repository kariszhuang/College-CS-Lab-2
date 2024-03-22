// Karis 02/20/24, using Visual Studio Code
import java.util.Scanner;

public class Lab3 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.print(" Enter the three sides of a triangle: ");

        // Read the three input 
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
        // vscode asks me to close scanner to prevent "resource leak"
        input.close();

        // First Check: If one or more of the values is 0, program stops
        if (a * b * c == 0) {
            System.out.println("That is not a valid triangle.");
        }

        else {
            // Further check if it's valid:
            if (a + b >= c && b + c >= a && a + c >= b && a > 0 && b > 0 && c > 0) {

                // It's Valid!!
                if (a == b && b == c) {
                    System.out.println("That is an equilateral triangle.");
                } else if (a == b || b == c || c == a) {
                    System.out.println("That is an iosceles triangle.");
                } else {
                    System.out.println("That is a scalene triangle.");
                }

                // Calculate the area:
                double s = (a + b + c) / 2.0;
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

                // Only get two decimal places: (btw (int) is similar to Math.floor in JavaScript)
                area = (int) (area * 100) / 100.0;

                // Output the area
                System.out.println("Its area is: " + area);

            }

            else {
                System.out.println("That is not a valid triangle.");
            }

        }
    }
}
