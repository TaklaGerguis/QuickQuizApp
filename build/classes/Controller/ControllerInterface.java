/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Takla Gerguis
 */
public interface ControllerInterface {
    
    public String getQuestionText();
    public int getScore();
    public String getStudentName();
    public void checkAnswer(Object answer);
}
