// Karis. Use Visual Studio Code 
// 03/20/2024

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        // Original length: BASE_NUM
        final int BASE_NUM = 10;
        int[] inputList = new int[BASE_NUM];

        Scanner input = new Scanner(System.in);

        int counter = 0;
        System.out.println("Enter some numbers (Ctrl-d to quit):");
        if (input.hasNextInt()) {
            while (input.hasNextInt()) {
                int newInput = input.nextInt();

                // When input numbers exceed the length of the inputList
                if (counter >= inputList.length) {
                    // We expand the inputList by BASE_NUM, and copy the original list to tempList
                    int[] tempList = new int[inputList.length + BASE_NUM];
                    for (int i = 0; i < inputList.length; i++) {
                        tempList[i] = inputList[i];
                    }
                    // give reference of tempList to inputList
                    inputList = tempList;
                }

                // Now safely put input to the array
                inputList[counter] = newInput;
                counter++;
            }

            // Reverse and output
            System.out.println();
            for (int i = counter - 1; i >= 0; i--) {
                System.out.print(inputList[i] + " ");
            }
        }

    }
}