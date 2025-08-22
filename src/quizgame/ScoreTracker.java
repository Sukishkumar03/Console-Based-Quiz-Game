package quizgame;

import java.util.Scanner;

public class ScoreTracker {
    static Scanner sc = new Scanner(System.in);
    String userName;
    public static void userInfo(){
        ScoreTracker st = new ScoreTracker();
        System.out.println("Enter your display name: ");
        st.userName = sc.nextLine();
    }

    public static int score(String fileName){
        int score = 0;
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
        return score;
    }
}
