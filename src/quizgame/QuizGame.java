package quizgame;

import java.util.Scanner;

public class QuizGame {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int score = 0;
        String fileName = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";
        try {
            score = QuizEngine.displayQuestion(fileName);
        } catch (InvalidAnswer e) {
            System.out.println("Exception caught you must have entered wrong input: "+e.getMessage());
            System.out.println("Do you want to try again from start (y/n)? ");
            char ch = sc.nextLine().toLowerCase().charAt(0);
            switch (ch){
                case 'y':
                    QuizEngine.displayQuestion(fileName);
                    break;

                case 'n':
                    System.exit(0);
            }
        }
        System.out.println("Final score: "+score);
    }
}
