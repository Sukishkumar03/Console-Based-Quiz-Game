package quizgame;

import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        String fileName = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";
        int score = ScoreTracker.score(fileName);
        System.out.println("Final score: "+score);
    }
}
