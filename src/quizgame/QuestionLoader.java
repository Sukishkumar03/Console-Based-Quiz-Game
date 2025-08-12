package quizgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class QuestionLoader {
    static ArrayList<String> questions = new ArrayList<>();

    public static void readQuestion() throws IOException {
        String path = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/questions";
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        while(true){
            String line = br.readLine();
            if(line == null){
                break;
            }
            questions.add(line);
        }
        System.out.println(questions);
    }
}
