import java.util.Scanner;

public class StudentGradeCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Number of subjects
    int numofSubjects;

    System.out.print("Enter the number of subjects: ");
    numofSubjects = input.nextInt();

    // Array to store marks
    int[] marks = new int[numofSubjects];

    // Take input for marks obtained in each subject
    for (int i = 0; i < numofSubjects; i++) {
      System.out.print("Enter the marks obtained in subject " + (i + 1) + ": ");
      marks[i] = input.nextInt();
    }

    // Calculate total marks
    int totalMarks = 0;
    for (int mark : marks) {
      totalMarks += mark;
    }

    // Calculate average percentage
    double averagePercentage = (double) totalMarks / numofSubjects;

    // Determine grade
    char grade;
    if (averagePercentage >= 90) {
      grade = 'A';
    } else if (averagePercentage >= 80) {
      grade = 'B';
    } else if (averagePercentage >= 70) {
      grade = 'C';
    } else if (averagePercentage >= 60) {
      grade = 'D';
    } else {
      grade = 'F';
    }

    // Display results
    System.out.println("\nResults:");
    System.out.println("Total Marks: " + totalMarks);
    System.out.println("Average Percentage: " + averagePercentage + "%");
    System.out.println("Grade: " + grade);

    input.close();
  }
}
