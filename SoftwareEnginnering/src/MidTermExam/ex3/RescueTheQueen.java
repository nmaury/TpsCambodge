package MidTermExam.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RescueTheQueen {
    private List<Question> questionList;
    private int questionNumber;
    private Scanner sc;
    private boolean alive;
    public RescueTheQueen(List<Question> questionList) {
        System.out.print("Once upon a time, there is a beautiful princess living in harmony in a pretty kingdom. One day, there is a black wizard\n"+
                "captured the princess. A hero of such a game should answer the questions and take decisions that influence game \n"+
                "result\n\n");
        this.questionList = questionList;
        this.questionNumber=0;
        this.sc = new Scanner(System.in);
        this.alive=true;
        this.displayQuestion();
    }
    private void displayQuestion(){
        Question currentQuestion = this.questionList.get(this.questionNumber);
        System.out.println(currentQuestion.getQuestionText());
        System.out.println("Your choice :");
        String choice = this.sc.next();
        switch (choice.toUpperCase()){
            case "A":
                if(!currentQuestion.checkAnswer(0)){
                    alive=false;
                }
                break;
            case "B":
                if(!currentQuestion.checkAnswer(1)){
                    alive=false;
                }
                break;
            default:
                this.sc.close();
                System.exit(-1);
        }
        if(alive){
            if(this.questionNumber<2) {
                System.out.println("You made it ! Go to the next question !");
                this.questionNumber++;
                this.displayQuestion();
            }else{
                System.out.println("Congratulations ! You have recue the princess !");
                this.sc.close();
                System.exit(0);
            }
        }else{
            System.out.println("You are dead !");
            this.sc.close();
            System.exit(-2);
        }
    }

    public static void main(String[] args) {
        List<Question> listQuestion = new ArrayList<>();
        List<String> possibleanswer1 =new ArrayList<>();
        possibleanswer1.add("A.  You took the boat and successfully crossed the river");
        possibleanswer1.add("B.  You took the raft, and it breaks in the middle of river beacause of the sharp rocks. Game over!!");
        listQuestion.add(new Question("Q1. You are on a horse in the way to rescue the \n"+
                "princess, you face the first trial, here it is a small\n"+
                "river. Next to it there are a boat and a raft. Which\n"+
                "one will you take?(A.Boat,B.Raft)",possibleanswer1,"A.  You took the boat and successfully crossed the river"));
        List<String> possibleanswer2 = new ArrayList<>();
        possibleanswer2.add("A. The Rocky Road is a little hard to travel but you successfully crossed it");
        possibleanswer2.add("B.  The Muddy Road absorbed both the horse and you. Game over !!");
        listQuestion.add(new Question("Q2.  You pass into a dark jungle. In the \n"+
                "jungle, you face the second trial, the road is broken\n"+
                "into 2 ways: Rocky Road and Muddy Road.\n"+
                "Which road will you take? (A. Rocky Road, B. Muddy\n"+
                "Road)",possibleanswer2,"A. The Rocky Road is a little hard to travel but you successfully crossed it"));
        List<String> possibleanswer3 = new ArrayList<>();
        possibleanswer3.add("A. You try to pass past, but the dragon notices your presence and transforms you into ashes. You are dead!! GAME is over !!!!");
        possibleanswer3.add("B.  Congratulation, you have passed all tests of honor. Princess gets to you!!! (Hero becomes the future king)");
        listQuestion.add(new Question("Q3. You reach temple, you enter the \n"+
                "temple. A person is attacking by a dragon ! To move\n"+
                "further, not paying to them of attention? (A.Yes, B.\n"+
                "No)",possibleanswer3,"B.  Congratulation, you have passed all tests of honor. Princess gets to you!!! (Hero becomes the future king)"));
        RescueTheQueen rescueTheQueen = new RescueTheQueen(listQuestion);

    }
}
