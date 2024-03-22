import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        // Calculate Pi using the approxiation
        double pi = 0.0;
        int seriesNum = 666666;
        for (int i = 0; i < seriesNum; i++) {
            pi+= 4 *  Math.pow(-1,i) / (2 * i +1);
        }

        System.out.println(pi);

        // Get input
        System.out.print("Which digit past the decimal point do you want? ");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        
        // Output the digit
        
        
        int digit = (int)(pi * Math.pow(10, in) % 10);
        System.out.println(digit);
    
    }
}
