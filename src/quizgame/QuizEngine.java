package quizgame;

import java.util.ArrayList;
import java.util.Scanner;

class InvalidAnswer extends RuntimeException{
    InvalidAnswer(String message){
        super(message);
    }
}

//add timer method
public class QuizEngine {
    static int score;

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Question> correctAnswer = new ArrayList<>();

    static ArrayList<Question> wrongAnswer = new ArrayList<>();

    public static int displayQuestion(String fileName){
        ArrayList<Question> questions = QuestionLoader.loadQuestion(fileName);
        int i = 0;
        while (i < questions.size()){
            System.out.println("Question number: "+ (i+1));
            System.out.print(questions.get(i));
            System.out.println("Enter the correct option here: ");
            String answer = sc.nextLine();
            if(answer.charAt(0) <= 'a' && answer.charAt(0) >= 'd'){
                throw new InvalidAnswer("Enter valid options a-d");
            }
            if(answer.charAt(0) == questions.get(i).getCorrectOption()){
                System.out.println("Correct answer!!"+'\n');
                correctAnswer.add(questions.get(i));
                score++;
            }else{
                System.out.println("Wrong answer.");
                System.out.println("correct answer: "+questions.get(i).getCorrectOption()+'\n');
                wrongAnswer.add(questions.get(i));
            }
            i++;
        }
        return score;
    }

    public static ArrayList<Question> getCorrectAnswer(){
        return correctAnswer;
    }

    public static ArrayList<Question> getWrongAnswer(){
        return wrongAnswer;
    }
}