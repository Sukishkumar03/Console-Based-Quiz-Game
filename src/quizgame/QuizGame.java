package quizgame;

import java.io.IOException;

public class QuizGame {
    public static void main(String[] args) {
        try {
            QuestionLoader.readQuestion();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
