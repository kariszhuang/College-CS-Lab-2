// Karis- Xuping Zhuang 02/26/2024

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Use nextLine to grab the whole expression.
        String input = in.nextLine();
        in.close();

        String output;

        if (input.indexOf("<=") != -1) {
            int index = input.indexOf("<=");
            // Use trim() to remove leading and trailing spaces
            int a = Integer.parseInt(input.substring(0, index).trim()),
            b = Integer.parseInt(input.substring(index + 2).trim());

            if (a <= b) {
                output = "True";
            } else {
                output = a + ">" + b;
            }

        } else if (input.indexOf(">=") != -1) {
            int index = input.indexOf(">=");
            int a = Integer.parseInt(input.substring(0, index).trim()),
            b = Integer.parseInt(input.substring(index + 2).trim());
            if (a >= b) {
                output = "True";
            } else {
                output = a + "<" + b;
            }

        } else if (input.indexOf(">") != -1) {
            int index = input.indexOf(">");
            int a = Integer.parseInt(input.substring(0, index).trim()),
            b = Integer.parseInt(input.substring(index + 1).trim());
            if (a > b) {
                output = "True";
            } else {
                output = a + "<=" + b;

            }
        } else if (input.indexOf("<") != -1) {
            int index = input.indexOf("<");
            int a = Integer.parseInt(input.substring(0, index).trim()),
            b = Integer.parseInt(input.substring(index + 1).trim());
            if (a < b) {
                output = "True";
            } else {
                output = a + ">=" + b;

            }
        } else {
            output = "Please use relational operators <=, >=, < or >.";
        }
        System.out.println(output);
    }
}
