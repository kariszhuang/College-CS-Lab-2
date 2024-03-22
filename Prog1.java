import java.util.Scanner;

/* @ Karis 02/23/2024
 * This program checks if the input date is valid and output the previous date. 
 */

public class Prog1 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt(), day = input.nextInt(), year = input.nextInt();
        input.close();

        String[] monthName = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        boolean isValid = true;

        // Check the year first.

        if (year <= 0 || year > 2099) {
            System.out.println("Invalid year:" + year + " (year shoud between 1 and 2099)");
        } else {
            // Have passed the first test! Check the month now (1-12)
            if (month > 12 || month < 1) {
                System.out.println("Invalid month:" + month + " (month should between 1 and 12)");
                isValid = false;
            }

            // Month and Year are valid! Now check the day.
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

                if (day > 31 || day < 1) {
                    System.out.println("Invalid day:" + day + " (" + monthName[month - 1] + " has 31 days)");
                    isValid = false;
                }
            }

            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30 || day < 1) {
                    System.out.println("Invalid day: " + day + " (" + monthName[month - 1] + " has 30 days)");
                    isValid = false;
                }
            }

            else if (month == 2) { // February
                // Check for leap year
                boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                int febDays = isLeapYear ? 29 : 28;
                if (day > febDays || day < 1) {
                    System.out.println("Invalid day: " + day + " (February has " + febDays + " days in a "
                            + (isLeapYear ? "leap" : "common") + " year)");
                    isValid = false;
                }
            }

            // Finally everything is correct. Now output the previous date.
            if (isValid) {

                // set default variables for month and year
                int previousMonth = month, previousYear = year, previousDay;

                if (day == 1) {
                    // Go to last day of the previous month

                    if (month == 1) {
                        previousYear -= 1;
                        previousMonth = 12;
                        previousDay = 31;
                    }

                    else {
                        int[] MonthDay = { 31, (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28, 31,
                                30, 31, 30, 31, 31, 30, 31, 30, 31 };
                        previousMonth -= 1;
                        previousDay = MonthDay[previousMonth - 1];

                    }
                }
                // Normal case
                else {
                    previousDay = day - 1;
                }

                // Format: December 1, 2018; use the array that is created in the beginning;
                System.out.println(monthName[previousMonth - 1] + " " + previousDay + ", " + previousYear);

            }

        }

    }
}