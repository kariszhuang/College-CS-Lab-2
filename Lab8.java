import java.util.Scanner;
import java.util.Random;

public class Lab8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many random numbers do you want? ");
        int howMany = in.nextInt();
        int[] myArray;
        Random rand = new Random(1234);

        myArray = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            myArray[i] = rand.nextInt(1000);
        }

        // print generated random array:
        System.out.println("myArray before reverseInPlace: " + printArray(myArray));
        // reverse in place:
        reverseInPlace(myArray);
        System.out.println("myArray after reverseInPlace: " + printArray(myArray));
        System.out.println();

        int[] reversedArray = reverseDoNotModify(myArray);
        System.out.println("myArray after reverseDoNotModify: " + printArray(myArray));
        System.out.println("Returned array from reverseDoNotModify: " + printArray(reversedArray));

    }

    // Use two pointers. One go from left to right and the other go from right to
    // left
    // reverse the two element that the two pointers point at
    public static void reverseInPlace(int[] array) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        while (leftPointer < rightPointer) {
            int tempLeft = array[leftPointer];
            array[leftPointer] = array[rightPointer];
            array[rightPointer] = tempLeft;
            // Move the pointers
            leftPointer++;
            rightPointer--;
        }
    }

    public static int[] reverseDoNotModify(int array[]) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public static String printArray(int array[]) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += array[i];
            output += " ";
        }
        return output;
    }
}
