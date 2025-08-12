package quizgame;

public class Question {
    String questionText;
    final String[] options;
    private final char correctOption;
    public Question(String questionText, String[] options, char correctOption){
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    @Override
    public String toString() {
        return questionText + "\n" +
                "a) " + options[0] + "  " +
                "b) " + options[1] + "  " +
                "c) " + options[2] + "  " +
                "d) " + options[3] + "  " ;
    }
    public char getCorrectOption() {
        return correctOption;
    }
}
