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
public abstract  class Question
{
    private final String questionText;
    
    Question(String myText)
    {
        this.questionText = myText; 
    }

    public String getMyText() {
        return questionText;
    }
    public abstract String getQuestion();
    public abstract String getAnswer();
    public abstract boolean checkAnswer(Object answer);
}