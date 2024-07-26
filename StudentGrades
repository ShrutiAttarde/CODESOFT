import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt(), totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            totalMarks += scanner.nextInt();
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = averagePercentage >= 90 ? 'A' : averagePercentage >= 80 ? 'B' : averagePercentage >= 70 ? 'C' : averagePercentage >= 60 ? 'D' : 'F';

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
