package quizgame;

public class Question {
    String questionText;
    String[] options;
    private final char correctOption;
    public Question(String questionText, String[] options, char correctOption){
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public char getCorrectOption() {
        return correctOption;
    }
}
