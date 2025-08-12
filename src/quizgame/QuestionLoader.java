package quizgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionLoader {

    public static ArrayList<Question> loadQuestion(String fileName){
        ArrayList<Question> question = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null){
                String questionText = line;
                String[] options = new String[4];
                for (int i = 0; i < options.length; i++) {
                    options[i] = br.readLine();
                }
                String correctLine = br.readLine();
                if(correctLine == null || correctLine.length() != 1){
                    System.out.println("Invalid answer format skipping question");
                    continue;
                }
                char correctOption = correctLine.charAt(0);
                question.add(new Question(questionText, options, correctOption));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return question;
    }

}