package quizgame;

import java.util.Scanner;

public class ScoreTracker {
    static Scanner sc = new Scanner(System.in);
    private static String userName;

    public static int userInfo(String fileName, String difficulty){
        System.out.println("Enter your display name: ");
        userName = sc.nextLine();
        int score = score(fileName,difficulty);
        return score;
    }

    public static String getUserName(){
        return userName;
    }

    public static int score(String fileName, String difficulty){
        int score = 0;
        try {
            score = QuizEngine.displayQuestion(fileName, difficulty);
        } catch (InvalidAnswer e) {
            System.out.println("Exception caught you must have entered wrong input: "+e.getMessage());
            System.out.println("Do you want to try again from start (y/n)? ");
            char ch = sc.nextLine().toLowerCase().charAt(0);
            switch (ch){
                case 'y':
                    QuizEngine.displayQuestion(fileName, difficulty);
                    break;
                case 'n':
                    System.exit(0);
            }
        }
        return score;
    }
}
