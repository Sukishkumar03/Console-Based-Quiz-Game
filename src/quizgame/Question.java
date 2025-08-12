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
                options[0] + "\n" +
                options[1] + "\n" +
                options[2] + "\n" +
                options[3] + "\n";
    }

    public char getCorrectOption() {
        return correctOption;
    }
}
