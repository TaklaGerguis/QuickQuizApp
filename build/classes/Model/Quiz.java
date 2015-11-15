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
public final class Quiz 
{
    private final Question [] questions;
    private int score;
    private int counter;
    
    public Quiz(Question[] questions)
    {
        this.questions = questions;
        this.score = 0;
        this.counter = 0;
    }
    
    public void incrementScore()
    {
        score++;
    }
    public int getScore()
    {
      return score;
    }
  
    public Question getCurrentQuestion()
    {
        return counter == questions.length? null : questions[counter++]; 
    }  
}
