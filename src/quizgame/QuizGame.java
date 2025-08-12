package quizgame;

import java.io.IOException;
import java.util.ArrayList;

public class QuizGame {
    public static void main(String[] args) {
        int score = QuizEngine.displayQuestion("/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions");
        System.out.println("Final score: "+score);
    }
}
