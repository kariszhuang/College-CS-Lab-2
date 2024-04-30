// Karis. 04/29. Visual Studio Code

import java.util.*;

public class Lab9 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you want? ");
        int num = in.nextInt();
        int[] randomArray = getRandomArray(num);

        // bubble sort
        for (int i = 0; i < num; i++) {
            for (int j = num - 1; j > i; j--) {
                if (randomArray[j] < randomArray[j - 1]) {
                    // Switch
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j - 1];
                    randomArray[j - 1] = temp;
                }
            }
        }

        System.out.print("Here is a random sorted Array: ");
        for (int i = 0; i < num; i++) {
            System.out.print(randomArray[i] + " ");
        }

        System.out.print("\nFor what value would you like to search? ");
        int target_value = in.nextInt();
        int target_index = bsearch(randomArray, target_value);
        if (target_index == -1) {
            System.out.println("The value " + target_value + " does not occur in the array.");
        } else {
            System.out.println("The value " + target_value + " occurs at index " + target_index);
        }
    }

    public static int bsearch(int[] arr, int key) {
        int leftPointerIndex = 0;
        int rightPointerIndex = arr.length - 1;

        while (leftPointerIndex < rightPointerIndex) {
            int midIndex = (leftPointerIndex + rightPointerIndex) / 2;
            if (arr[midIndex] == key) {
                return midIndex;
            }
            if (arr[midIndex] < key) {
                leftPointerIndex = midIndex + 1;
            } else {
                rightPointerIndex = midIndex - 1;
            }
        }
        return -1;
    }

    public static int[] getRandomArray(int howMany) {
        if (howMany < 0) {
            return null;
        }
        int[] randomArray = new int[howMany];
        Random rand = new Random();
        for (int i = 0; i < howMany; i++) {
            randomArray[i] = rand.nextInt(31);
        }
        return randomArray;
    }
}
