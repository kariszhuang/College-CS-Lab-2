
/**
 * This lab will give you practice working with loops. The idea here is that
your program will read in two non-negative ints from the user, not necessarily distinct and
not necessarily in non-decreasing order and then output the sum of all the digits of all the
numbers between (and including) the two input numbers
 *
 * @Karis
 * @03/04/2024
 */

 import java.util.Scanner;
 public class Lab5
 {
     public static void main(String args[]){
        Scanner input = new Scanner(System.in);
         boolean input_status = true;
         int begin = 0 , end = 0; // declare them out the loop => global variable
         
         // First, read input
         while (input_status){
            System.out.print("Enter two non-negative integers: ");
            begin = input.nextInt();
            end = input.nextInt();
            if(begin >= 0 && end >= 0){
                input_status = false; // break out the loop
            }
            else{
                System.out.println("Non-negative integers are required.");
            }
         }
         // make sure begin < end
         if (begin > end){
             int temp = end;
             end = begin;
             begin = temp; 
         }
         int sum = 0;
         for (int i = begin; i <= end; i++){
            // algorithm: %10, add to sum, then i/10.... until i/10 = 0
            int num = i;
            while (num != 0){
                sum += num % 10;
                num = num / 10;
            }
         }
         System.out.println("Sum of all the digits: "+sum);



     }
 
 }
 