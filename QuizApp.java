//Create separate Class for QuizGame
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static final int TIME_LIMIT = 10; // seconds

    private QuizQuestion[] questions;
    private int score;
    private Scanner scanner;

    public QuizGame(QuizQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        for (int i = 0; i < questions.length; i++) {
            QuizQuestion question = questions[i];
            System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestion());

            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int answerIndex = getAnswerWithTimeout();

            if (question.isCorrectAnswer(answerIndex - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + (question.getCorrectAnswerIndex() + 1));
            }
        }

        showResults();
    }

    private int getAnswerWithTimeout() {
        Timer timer = new Timer();
        final int[] selectedOption = {0};
        TimerTask task = new TimerTask() {

            public void run() {
                System.out.println("\nTime is up!");
                scanner.nextLine();
                selectedOption[0] = -1;
            }
        };
        timer.schedule(task, TIME_LIMIT * 1000);

        System.out.print("Select an option (1-" + questions[0].getOptions().length + "): ");
        while (true) {
            if (scanner.hasNextInt()) {
                selectedOption[0] = scanner.nextInt();
                break;
            } else {
                System.out.print("Invalid input. Try again: ");
                scanner.next();
            }
        }
        timer.cancel(); // Cancel the timer
        return selectedOption[0];
    }

    private void showResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }
}

//Create separate Class for QuizQuestion
public class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public QuizQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

//Create separate Class for QuizApp
public class QuizApp {
    public static void main(String[] args) {
        QuizQuestion[] questions = new QuizQuestion[]{
            new QuizQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2),
            new QuizQuestion("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1),
            new QuizQuestion("What is the color of the sky?", new String[]{"Green", "Blue", "Red", "Yellow"}, 1)
        };

        QuizGame game = new QuizGame(questions);
        game.startQuiz();
    }
}
