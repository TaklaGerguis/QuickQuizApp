/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Takla Gerguis
 */
public class TrueFalseQuestion extends Question
{
    private final boolean myAnswer;

    public TrueFalseQuestion(String myText, boolean myAnswer) {
        super(myText);
        this.myAnswer = myAnswer;
    }

    @Override
   public  String getQuestion() {
       return getMyText();
    }

    @Override
    public String getAnswer() {
        return myAnswer ? "True" : "False";
    }

    @Override
    public boolean checkAnswer(Object answer) {
        boolean studentAnswer = (boolean) answer;
        return studentAnswer == myAnswer;
    }   
}
