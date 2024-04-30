import java.util.Scanner;

/*
 *  
 *  ...Description...
 *  @ Xuping Zhuang (Karis), Weiyu Zhang (Zoey)
 */
public class Prog4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter weights (quizzes, labs, programs, exams): ");
        int[] weights = { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };
        System.out.print("Enter maximum scores (quizzes, labs, programs, exams): ");
        int[] maxScores = { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };

        double quizAdjustedAverage = processType(in, "QUIZ", maxScores[0], true);
        double labAdjustedAverage = processType(in, "LAB", maxScores[1], true);
        double programRawAverage = processType(in, "PROGRAM", maxScores[2], false);
        double examRawAverage = processType(in, "EXAM", maxScores[3], false);

        double finalGrade = (int) (quizAdjustedAverage * weights[0] + labAdjustedAverage * weights[1]
                + programRawAverage * weights[2] + examRawAverage * weights[3]) / 100.0;

        printFinalSummary(finalGrade);
    }

    /**
     * ...description...
     * 
     * @param inType
     * @param inMax
     * @param dropOne
     * @return
     */
    public static double processType(Scanner in, String inType, int inMax, boolean dropOne) {
        double pct = 0.0;
        System.out.print("\nHow many " + inType + " scores? ");
        int xNum = in.nextInt();
        double[] xScores = new double[xNum];

        System.out.print("Enter " + inType + " scores: ");

        for (int i = 0; i < xNum; i++) {
            xScores[i] = in.nextDouble();
        }
        double xMin = xScores[0];
        double xMax = xScores[0];
        double xSum = 0;
        for (int i = 0; i < xNum; i++) {
            xSum += xScores[i];
            if (xScores[i] < xMin) {
                xMin = xScores[i];
            }
            if (xScores[i] > xMax) {
                xMax = xScores[i];
            }
        }
        double xRawAverage = (int) (xSum / xNum / inMax * 100) / 100.0;
        pct = xRawAverage;
        double xStandardDeviation = getStandardDeviation(xScores, xSum / xNum, xNum);
        // Output QUIZ information
        System.out.println("\n" + inType + " summary\n-----------------------------");
        System.out.println("              How many: " + xNum);
        System.out.println("                   Min: " + xMin);
        System.out.println("                   Max: " + xMax);
        System.out.println("           Raw average: " + xRawAverage);
        if (dropOne) {
            double xAdjustedAverage = (int) ((xSum - xMin) / (xNum - 1) / inMax * 100) / 100.0;
            System.out.println("      Adjusted average: " + xAdjustedAverage);
            pct = xAdjustedAverage;
        }
        System.out.println("Raw standard deviation: " + xStandardDeviation);
        return pct;
    }

    public static double getStandardDeviation(double[] xScores, double xMu, int xNum) {
        double xSquareSum = 0;
        for (int i = 0; i < xNum; i++) {
            xSquareSum += Math.pow((xScores[i] - xMu), 2);
        }
        return (int) (Math.sqrt(xSquareSum / xNum) * 100) / 100.0;
    }

    /**
     * ...desceiption...
     * 
     * @param finalPct
     */
    public static void printFinalSummary(double finalPct) {
        double[] gradePointRangeList = { 91, 89, 97, 81, 79, 77, 71, 69, 67, 61, 55 };
        String[] gradeLetterList = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-" };

        // Initialize final letter
        String finalLetter = "F";

        // Check one by one through the gradePointRangeList to find out what is the
        // grade letter
        for (int i = 0; i < gradeLetterList.length; i++) {
            if (finalPct * 100 > gradePointRangeList[i]) {
                finalLetter = gradeLetterList[i];
                break;
            }
        }

        System.out.println("\n\nFINAL summary\n-------------------------------------");
        System.out.println("Final grade adjusted average: " + finalPct);
        System.out.println(" Final grade adjusted letter: " + finalLetter);
        System.out.println("\nDONE. Normal termination.");

    }
}
