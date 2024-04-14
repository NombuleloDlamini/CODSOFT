import java.util.Scanner;

class QuizQuestion {
    String question;
    String[] options;
    int correctOption;

    QuizQuestion(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class Task4 {

    public static void main(String[] args) {
        QuizQuestion[] questions;

        // quiz questions

        questions = new QuizQuestion[]{
                new QuizQuestion("what colour is a carrot", new String[]{"A. yellow", "B. orange", "C. pink", "D. green"}, 1),
                new QuizQuestion("What element does the chemical symbol Au stand for?", new String[]{"A. gold", "B. aluminium", "C. silver", "D. iron"}, 0),
                new QuizQuestion("What's the national animal of Australia?", new String[]{"A. eagle", "B. lion", "C. elephant", "D. kangaroo"}, 3)
        };

        int score = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            QuizQuestion currentQuestion = questions[i];
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.question);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }
            System.out.println("Choose (A/B/C/D):");

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.next().toUpperCase();

            int correctOptionIndex = currentQuestion.correctOption;
            String correctOption = currentQuestion.options[correctOptionIndex].substring(0, 1);

            if (userAnswer.equals(correctOption)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctOption);
            }

            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }
}
