package quizgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizGame {
    static Scanner sc = new Scanner(System.in);
    static String easyQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";
    static String mediumQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/MediumQuestions";
    static String hardQuestion = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/HardQuestions";

    public static void mainMenu(){
        System.out.println("""
                1.Start
                2.Scoreboard
                3.Customer support
                4.Exit
                ========================================
                """);
    }

    public static void displayLevel(){
        System.out.println("""
                1.Easy
                2.Medium
                3.Hard
                4.Exit
                ========================================
                """);
    }
    public static void rulesEasy(){
        System.out.println("""
                Rules for Easy Questions:
                ----------------------------------------------
                1.Number of questions is users choice.
                2.Each correct answer will get 1 mark.
                3.There is no negative mark for wrong answers.
                ----------------------------------------------
                """);
    }
    public static void rulesMid(){
        System.out.println("""
                Rules for Medium Questions:
                ----------------------------------------------------
                1.Number of questions is users choice.
                2.Each correct answer will get 1 mark.
                3.There is no negative mark for wrong answers.
                4.There is a time limit of 30 seconds per questions.
                ----------------------------------------------------
                """);
    }
    public static void rulesHard(){
        System.out.println("""
                Rules for Hard Questions:
                ---------------------------------------------------
                1.Number of questions is users choice.
                2.Each correct answer will get 3 mark.
                3.There is a Negative mark -1 for each wrong answers.
                4.There is a time limit of 15 seconds per questions.
                ----------------------------------------------------
                """);
    }
    public static void easyQuestion(){
        System.out.println("Do you want to check the rules first? ");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        if(ch == 'y'){
            rulesEasy();
        }
        int score = ScoreTracker.userInfo(easyQuestion, "easy");
        String name = ScoreTracker.getUserName();
        System.out.println(name+" your Final score is: "+score);
    }
    public static void mediumQuestion(){
        System.out.println("Do you want to check the rules first? ");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        if(ch == 'y'){
            rulesMid();
        }
        int score = ScoreTracker.userInfo(mediumQuestion, "medium");
        System.out.println("Final score: "+score);
    }
    public static void hardQuestion(){
        System.out.println("Do you want to check the rules first? ");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        if(ch == 'y'){
            rulesHard();
        }
        int score = ScoreTracker.userInfo(hardQuestion, "hard");
        System.out.println("Final score: "+score);
    }

    public static void scoreboard(){

    }

    public static void customerSupport(){
        CustomerSupport.mainPage();
    }

    public static void mainUI(){
        System.out.println("|==========Welcome to Quiz app==========|");
        mainMenu();
        System.out.println("Select a option: ");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                levelSelect();
                break;
            case 2:
                scoreboard();
                break;
            case 3:
                customerSupport();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid Input");
        }
    }
    public static void levelSelect(){
        System.out.println("========================================");
        System.out.println("Select difficulty level: ");
        System.out.println("========================================");
        System.out.println("Each level has different rules");
        System.out.println("----------------------------------------");
        displayLevel();
        int choice = 0;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            char ch = sc.nextLine().toLowerCase().charAt(0);
            if(ch == 'y') levelSelect();
            else if(ch == 'n') System.exit(0);
        }
        switch (choice){
            case 1:
                easyQuestion();
                break;
            case 2:
                mediumQuestion();
                break;
            case 3:
                hardQuestion();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("You entered wrong input do you want to try again? ");
                char ch = sc.nextLine().toLowerCase().charAt(0);
                if(ch == 'y'){
                    levelSelect();
                }
                else if(ch == 'n'){
                    System.exit(0);
                }
        }
    }
    public static void quizGame(){
        mainUI();
        boolean isTrue = true;
        while (isTrue){
            System.out.println("Your quiz has ended select a option below");
            System.out.println("""
                    1.Return to main menu
                    2.Exit
                    """);
            System.out.print("Option: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    mainUI();
                    break;
                case 2:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Entered Wrong input terminating the application");
                    System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Press ENTER to start the quiz");
        sc.nextLine();
        System.out.println("|----------------------------------------|");
        quizGame();
    }
}