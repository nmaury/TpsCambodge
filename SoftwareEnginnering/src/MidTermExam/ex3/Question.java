package MidTermExam.ex3;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> possibleAnswers;
    private String corectionAnswer;

    public Question(String questionText, List<String> possibleAnswers, String corectionAnswer) {
        this.questionText = questionText;
        this.possibleAnswers = possibleAnswers;
        this.corectionAnswer = corectionAnswer;
    }
    public boolean checkAnswer(int id){
        System.out.println(this.possibleAnswers.get(id));
        return this.corectionAnswer.equals(this.possibleAnswers.get(id));
    }

    public String getQuestionText() {
        return questionText;
    }
}
