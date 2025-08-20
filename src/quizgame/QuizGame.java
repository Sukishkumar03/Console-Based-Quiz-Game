package quizgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizGame {
    static Scanner sc = new Scanner(System.in);
    static String easyQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";
    static String mediumQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/MediumQuestions";
    static String hardQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/HardQuestions";

    public static void displayLevel(){
        System.out.println("""
                1.Easy
                2.Medium
                3.Hard
                4.Exit
                ----------------------------------------
                """);
    }
    public static void rulesEasy(){
        System.out.println("""
                Rules for Easy Questions:
                1.Number of questions is users choice.
                2.Each correct answer will get 1 mark.
                3.There is no negative mark for wrong answers.
                4.There is no time limit.
                """);
    }
    public static void rulesMid(){
        System.out.println("""
                Rules for Medium Questions:
                1.Number of questions is users choice.
                2.Each correct answer will get 1 mark.
                3.There is no negative mark for wrong answers.
                4.There is a time limit of 30 sec per questions.
                """);
    }
    public static void rulesHard(){
        System.out.println("""
                Rules for Hard Questions:
                1.Number of questions is users choice.
                2.Each correct answer will get 3 mark.
                3.There is a Negative mark -1 for each wrong answers.
                4.There is a time limit of 15 sec per questions.
                """);
    }
    public static void easyQuestion(){
        System.out.println("Do you want to check the rules first? ");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        if(ch == 'y'){
            rulesEasy();
        }
        int score = ScoreTracker.score(easyQuestion);
        System.out.println("Final score: "+score);
    }

    public static void userInterface(){
        System.out.println("|----------Welcome to Quiz app-----------|");
        System.out.println("Select difficulty level: "+'\n' +"Each level has different rules");
        displayLevel();
        int choice = 0;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            char ch = sc.nextLine().toLowerCase().charAt(0);
            if(ch == 'y') userInterface();
            else if(ch == 'n') System.exit(0);
        }
        switch (choice){
            case 1:
                easyQuestion();
                break;
            case 2:
                int score = ScoreTracker.score(mediumQuestion);
                System.out.println("Final score: "+score);
                break;
            case 3:
                score = ScoreTracker.score(hardQuestion);
                System.out.println("Final score: "+score);
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("You entered wrong input do you want to try again? ");
                char ch = sc.nextLine().toLowerCase().charAt(0);
                if(ch == 'y'){
                    userInterface();
                }
                else if(ch == 'n'){
                    System.exit(0);
                }
        }
    }
    public static void main(String[] args) {
        System.out.print("Press ENTER to start the quiz");
        sc.nextLine();
        System.out.println("|----------------------------------------|");
        userInterface();
    }
}
