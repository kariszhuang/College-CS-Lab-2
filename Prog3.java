import java.util.Scanner;
/*
 *
 *  A smart calculator to calculate the scores in COMP SCI course, including 
 * quizzes, labs, programs, exams, and the overall grade. 
 *  @ Karis, using VSCode, 04/05/2024
 */

public class Prog3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input basic information and instantly store them in arrays
        System.out.print("Enter weights (quizzes, labs, programs, exams): ");
        int[] weights = { input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt() };
        System.out.print("Enter maximum scores (quizzes, labs, programs, exams): ");
        int[] maxScores = { input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt() };

        // -----------------------QUIZ-----------------------------------
        // Input QUIZ scores
        System.out.print("\nHow many QUIZ scores? ");
        int quizNum = input.nextInt();

        // Initialize an array with quizNum elements
        double[] quizScores = new double[quizNum];

        // Store the input scores into the array
        System.out.print("Enter QUIZ scores: ");
        for (int i = 0; i < quizNum; i++) {
            quizScores[i] = input.nextDouble();
        }

        // Only iterate ONCE to get min & max & raw average & adjusted average
        double quizMin = quizScores[0];
        double quizMax = quizScores[0];
        double quizSum = 0;
        for (int i = 0; i < quizNum; i++) {
            quizSum += quizScores[i];
            if (quizScores[i] < quizMin) {
                quizMin = quizScores[i];
            }
            if (quizScores[i] > quizMax) {
                quizMax = quizScores[i];
            }
        }
        double quizRawAverage = (int) (quizSum / quizNum / maxScores[0] * 100) / 100.0;
        double quizAdjustedAverage = (int) ((quizSum - quizMin) / (quizNum - 1) / maxScores[0] * 100) / 100.0;
        // Iterate the second time to get standard deviation
        double quizMu = quizSum / quizNum;
        double quizSquareSum = 0;
        for (int i = 0; i < quizNum; i++) {
            quizSquareSum += Math.pow((quizScores[i] - quizMu), 2);
        }
        double quizStandardDeviation = (int) (Math.sqrt(quizSquareSum / quizNum) * 100) / 100.0;

        // Output QUIZ information
        System.out.println("\nQUIZ summary\n-----------------------------");
        System.out.println("              How many: " + quizNum);
        System.out.println("                   Min: " + quizMin);
        System.out.println("                   Max: " + quizMax);
        System.out.println("           Raw average: " + quizRawAverage);
        System.out.println("      Adjusted average: " + quizAdjustedAverage);
        System.out.println("Raw standard deviation: " + quizStandardDeviation);

        // For the following three parts, I simply replace "quiz" to "lab/program/exam",
        // include capital letters
        // -----------------------LAB-----------------------------------
        // Input LAB scores
        System.out.print("\nHow many LAB scores? ");
        int labNum = input.nextInt();

        // Initialize an array with labNum elements
        double[] labScores = new double[labNum];

        // Store the input scores into the array
        System.out.print("Enter LAB scores: ");
        for (int i = 0; i < labNum; i++) {
            labScores[i] = input.nextDouble();
        }

        // Only iterate ONCE to get min & max & raw average & adjusted average
        double labMin = labScores[0];
        double labMax = labScores[0];
        double labSum = 0;
        for (int i = 0; i < labNum; i++) {
            labSum += labScores[i];
            if (labScores[i] < labMin) {
                labMin = labScores[i];
            }
            if (labScores[i] > labMax) {
                labMax = labScores[i];
            }
        }
        double labRawAverage = (int) (labSum / labNum / maxScores[1] * 100) / 100.0;
        double labAdjustedAverage = (int) ((labSum - labMin) / (labNum - 1) / maxScores[1] * 100) / 100.0;
        // Iterate the second time to get standard deviation
        double labMu = labSum / labNum;
        double labSquareSum = 0;
        for (int i = 0; i < labNum; i++) {
            labSquareSum += Math.pow((labScores[i] - labMu), 2);
        }
        double labStandardDeviation = (int) (Math.sqrt(labSquareSum / labNum) * 100) / 100.0;

        // Output LAB information
        System.out.println("\nLAB summary\n-----------------------------");
        System.out.println("              How many: " + labNum);
        System.out.println("                   Min: " + labMin);
        System.out.println("                   Max: " + labMax);
        System.out.println("           Raw average: " + labRawAverage);
        System.out.println("      Adjusted average: " + labAdjustedAverage);
        System.out.println("Raw standard deviation: " + labStandardDeviation);

        // -----------------------PROGRAM-----------------------------------
        // Input PROGRAM scores
        System.out.print("\nHow many PROGRAM scores? ");
        int programNum = input.nextInt();

        // Initialize an array with programNum elements
        double[] programScores = new double[programNum];

        // Store the input scores into the array
        System.out.print("Enter PROGRAM scores: ");
        for (int i = 0; i < programNum; i++) {
            programScores[i] = input.nextDouble();
        }

        // Only iterate ONCE to get min & max & raw average & adjusted average
        double programMin = programScores[0];
        double programMax = programScores[0];
        double programSum = 0;
        for (int i = 0; i < programNum; i++) {
            programSum += programScores[i];
            if (programScores[i] < programMin) {
                programMin = programScores[i];
            }
            if (programScores[i] > programMax) {
                programMax = programScores[i];
            }
        }
        double programRawAverage = (int) (programSum / programNum / maxScores[2] * 100) / 100.0;
        // Iterate the second time to get standard deviation
        double programMu = programSum / programNum;
        double programSquareSum = 0;
        for (int i = 0; i < programNum; i++) {
            programSquareSum += Math.pow((programScores[i] - programMu), 2);
        }
        double programStandardDeviation = (int) (Math.sqrt(programSquareSum / programNum) * 100) / 100.0;

        // Output PROGRAM information
        System.out.println("\nPROGRAM summary\n-----------------------------");
        System.out.println("              How many: " + programNum);
        System.out.println("                   Min: " + programMin);
        System.out.println("                   Max: " + programMax);
        System.out.println("           Raw average: " + programRawAverage);
        System.out.println("Raw standard deviation: " + programStandardDeviation);

        // -----------------------EXAM-----------------------------------
        // Input EXAM scores
        System.out.print("\nHow many EXAM scores? ");
        int examNum = input.nextInt();

        // Initialize an array with examNum elements
        double[] examScores = new double[examNum];

        // Store the input scores into the array
        System.out.print("Enter EXAM scores: ");
        for (int i = 0; i < examNum; i++) {
            examScores[i] = input.nextDouble();
        }

        // Only iterate ONCE to get min & max & raw average & adjusted average
        double examMin = examScores[0];
        double examMax = examScores[0];
        double examSum = 0;
        for (int i = 0; i < examNum; i++) {
            examSum += examScores[i];
            if (examScores[i] < examMin) {
                examMin = examScores[i];
            }
            if (examScores[i] > examMax) {
                examMax = examScores[i];
            }
        }
        double examRawAverage = (int) (examSum / examNum / maxScores[3] * 100) / 100.0;
        // Iterate the second time to get standard deviation
        double examMu = examSum / examNum;
        double examSquareSum = 0;
        for (int i = 0; i < examNum; i++) {
            examSquareSum += Math.pow((examScores[i] - examMu), 2);
        }
        double examStandardDeviation = (int) (Math.sqrt(examSquareSum / examNum) * 100) / 100.0;

        // Output EXAM information
        System.out.println("\nEXAM summary\n-----------------------------");
        System.out.println("              How many: " + examNum);
        System.out.println("                   Min: " + examMin);
        System.out.println("                   Max: " + examMax);
        System.out.println("           Raw average: " + examRawAverage);
        System.out.println("Raw standard deviation: " + examStandardDeviation);

        // -------------------FINAL---------------------------

        double[] gradePointRangeList = { 91, 89, 97, 81, 79, 77, 71, 69, 67, 61, 55 };
        String[] gradeLetterList = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-" };
        double finalGrade = (int) (quizAdjustedAverage * weights[0] + labAdjustedAverage * weights[1]
                + programRawAverage * weights[2] + examRawAverage * weights[3]) / 100.0;
        // Initialize final letter
        String finalLetter = "F";

        // Check one by one through the gradePointRangeList to find out what is the
        // grade letter
        for (int i = 0; i < gradeLetterList.length; i++) {
            if (finalGrade * 100 > gradePointRangeList[i]) {
                finalLetter = gradeLetterList[i];
                break;
            }
        }

        System.out.println("\n\nFINAL summary\n-------------------------------------");
        System.out.println("Final grade adjusted average: " + finalGrade);
        System.out.println(" Final grade adjusted letter: " + finalLetter);
        System.out.println("\nDONE. Normal termination.");

    }
}