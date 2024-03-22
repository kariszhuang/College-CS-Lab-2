import java.util.Scanner;
import java.util.HashMap;

/*
 *  GPA Calculator
 * 
 *      Input course number in each term and then the grades for each course.
 *      It'll output GPA in each term.
 * 
 *      If user enters -1, it will generate an overall summary
 * 
 *  @Karis. Visual Studio Code
 *  03/21/24
 */

public class Prog2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // I use a hashmap to store the grade key-value pairs
        // as it's cleaner and faster(O(1)) than a lot "if-statements"(O(N))
        HashMap<String, Double> grades = new HashMap<String, Double>();
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D+", 1.33);
        grades.put("D", 1.00);
        grades.put("D-", 0.67);
        grades.put("F", 0.00);

        // Default: 0. Add from 0 if there's any term
        double totalGradePoints = 0.0;
        int totalCredits = 0;
        int termCount = 0;

        int courseNum = input.nextInt();

        // begin each term
        while (courseNum != -1) {
            termCount++;

            int termCredits = 0;
            double termGradePoints = 0.0;
            double gradePoint;
            int credit;

            // based on coursNum, input the grades & credit of each course
            for (int i = 0; i < courseNum; i++) {
                // Get the input("A"), find the grade point with Hashmap
                gradePoint = grades.get(input.next());
                credit = input.nextInt();

                termCredits += credit;
                termGradePoints += gradePoint * credit;
            }
            // Avoid division-by-0
            double termGPA = (termCredits == 0) ? 0.0 : termGradePoints / termCredits;

            System.out.println("Summary for term " + termCount);
            System.out.println("----------------------------------");

            // Round the termGPA
            System.out.println("  Term total grade points:   " + ((int) (termGradePoints * 100 + 0.5)) / 100.0);
            System.out.println("       Term total credits:   " + termCredits);

            // Round the termGPA
            System.out.println("                 Term GPA:   " + ((int) (termGPA * 100 + 0.5)) / 100.0 + "\n");

            totalCredits += termCredits;
            totalGradePoints += termGradePoints;

            courseNum = input.nextInt();
        }

        // When the loop is done(input "-1"), print final summary

        // Avoid division-by-0
        double culmulativeGPA = (totalCredits == 0) ? 0.0 : totalGradePoints / totalCredits;

        // Print Summary
        System.out.println("Final summary");
        System.out.println("----------------------------------");
        System.out.println("            Overall terms:   " + termCount);
        System.out.println("       Total grade points:   " + ((int) (totalGradePoints * 100 + 0.5)) / 100.0);
        System.out.println("            Total credits:   " + totalCredits);
        System.out.println("           Cumulative GPA:   " + ((int) (culmulativeGPA * 100 + 0.5)) / 100.0 + "\n");
        System.out.println("Done. Normal termination.");

    }
}
