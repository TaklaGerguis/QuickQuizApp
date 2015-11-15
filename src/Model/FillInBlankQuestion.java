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
public class FillInBlankQuestion extends Question 
{
    private final String myAnswer;

    public FillInBlankQuestion(String myText, String myAnswer) {
        super(myText);
        this.myAnswer = myAnswer;
    }

    @Override
    public String getQuestion() {
        return getMyText() + "\nFill in the blank.";
    }

    @Override
    public String getAnswer() {
        return myAnswer;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        String studentAnswer = (String) answer;
        return myAnswer.equals(answer);   
    }
}
