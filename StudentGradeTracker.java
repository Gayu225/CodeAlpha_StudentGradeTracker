import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        String[] studentNames = new String[numberOfStudents];
        int[] grades = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter the name for student " + (i + 1) + ":");
            studentNames[i] = scanner.nextLine();

            System.out.println("Enter the grade for " + studentNames[i] + ":");
            grades[i] = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }

        if (numberOfStudents > 0) {
            int highestGrade = getHighestGrade(grades);
            int lowestGrade = getLowestGrade(grades);
            double average = getAverageGrade(grades);

            ArrayList<String> highestGradeStudents = getStudentsWithGrade(studentNames, grades, highestGrade);
            ArrayList<String> lowestGradeStudents = getStudentsWithGrade(studentNames, grades, lowestGrade);

            System.out.println("Highest Grade: " + highestGrade);
            System.out.println("Students with the highest grade: " + String.join(", ", highestGradeStudents));
            System.out.println("Lowest Grade: " + lowestGrade);
            System.out.println("Students with the lowest grade: " + String.join(", ", lowestGradeStudents));
            System.out.println("Average Grade: " + average);
        } else {
            System.out.println("No grades entered.");
        }
    }

    private static int getHighestGrade(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static int getLowestGrade(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    private static double getAverageGrade(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    private static ArrayList<String> getStudentsWithGrade(String[] studentNames, int[] grades, int targetGrade) {
        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == targetGrade) {
                students.add(studentNames[i]);
            }
        }
        return students;
    }
}
