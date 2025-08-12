package quizgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionLoader {
    private final static ArrayList<String> questions = new ArrayList<>();
    static String path = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";

    public static void loadQuestion(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            while(true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                questions.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<String> getQuestion(){
        return new ArrayList<>(questions);
    }
}
