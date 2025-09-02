package quizgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class InvalidAnswer extends RuntimeException{
    InvalidAnswer(String message){
        super(message);
    }
}

public class QuizEngine {
    static int score;
    static Scanner sc = new Scanner(System.in);

    public static void getAnswer(String fileName, String difficulty){
        score = 0;
        ArrayList<Question> questions = QuestionLoader.loadQuestion(fileName);
        Collections.shuffle(questions);
        int i = 0;
        boolean isTrue = true;
        int numOfQuestion = 0;
        while (isTrue){
            System.out.println("Enter the number of questions? ");
            numOfQuestion = sc.nextInt();
            if(numOfQuestion <= questions.size() && numOfQuestion > 0){
                isTrue = false;
            }
            else {
                System.out.println("Total available questions: "+questions.size()+" Enter within that range and question can't be 0 or less than 0");
            }
        }
        sc.nextLine();
        while (i < numOfQuestion){
            System.out.println("Question number: "+ (i+1));
            System.out.print(questions.get(i));
            System.out.println('\n'+"Enter your answer option here: ");
            String answer =  sc.nextLine().toLowerCase();
                if (answer.charAt(0) < 'a' || answer.charAt(0) > 'd') {
                    throw new InvalidAnswer("Enter valid options a-d");
                }
                if (answer.charAt(0) == questions.get(i).getCorrectOption()) {
                    if(difficulty.equals("easy") || difficulty.equals("medium")) {
                        System.out.println("Correct answer" + '\n');
                        score++;
                    } else if (difficulty.equals("hard")) {
                        System.out.println("Correct answer" + '\n');
                        score += 3;
                    }
                } else {
                    if(difficulty.equals("easy") || difficulty.equals("medium")) {
                        System.out.println("Wrong answer." + '\n');
                    } else if (difficulty.equals("hard")) {
                        System.out.println("Wrong answer." + '\n');
                        score--;
                    }
                }
            i++;
        }
    }
    public static int displayQuestion(String fileName, String difficulty){
        getAnswer(fileName, difficulty);
        return score;
    }
}