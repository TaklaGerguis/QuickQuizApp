/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddQuestion;
import Model.GenerateDataInterface;
import Model.GenerateFromFile;
import Model.Question;
import Model.Quiz;
import Model.TrueFalseQuestion;
import View.EndView;
import View.InstructorModeView;
import View.QuestionView;
import View.QuizView;
import View.TrueFalseView;
import javax.swing.JFrame;

/**
 *
 * @author Takla Gerguis
 */
public class Controller implements ControllerInterface 
{
    private final String PSWRD = "admin";
    private Quiz quiz;
    private Question currentQuestion;
    private String studentName;
    private final String fileName;
    
   public Controller(String fileName){
       this.fileName = fileName;
   }

   public void start(JFrame frame)
   {
        GenerateDataInterface generateFromFile = new GenerateFromFile(fileName);
        //GenerateDataInterface generateFromDatabse = new GenerateFromDatabase(fileName);
       Question[] allQuestions = generateFromFile.generateQuestions();
       quiz = new Quiz(allQuestions);
       QuizView quizView = new QuizView(this);
       quizView.setVisible(true);
       if(frame != null)
            frame.dispose();
   }
   
    @Override
    public String getQuestionText() {
        currentQuestion = quiz.getCurrentQuestion();
        return currentQuestion == null? null : currentQuestion.getMyText();
    }

    @Override
    public int getScore() {
        return quiz.getScore();
    }

    @Override
    public String getStudentName() {
        return studentName;
    }

    @Override
    public void checkAnswer(Object answer) {
        if(currentQuestion.checkAnswer(answer))
            quiz.incrementScore();
    }

    public static void main(String[]args){
        String fileName="quiz.txt";
        Controller controller = new Controller(fileName);
        controller.start(null);
    }

    public void startQuestionView(JFrame view, String studentName) {
        this.studentName = studentName;
        startQuestionView(view);
    }
    
     public void startQuestionView(JFrame view) {
        currentQuestion = quiz.getCurrentQuestion();         
        if(currentQuestion == null){
                new EndView(this).setVisible(true);
        }
        else{
            if(currentQuestion.getClass() == TrueFalseQuestion.class)
                new TrueFalseView(this, currentQuestion).setVisible(true);
            else
                new QuestionView(this, currentQuestion).setVisible(true);
        }
        view.dispose();
    }

    public void startInstructorModeView(QuizView quizView, String pswrd) {
        if(pswrd.equals(PSWRD)){
            new InstructorModeView(this).setVisible(true);
            quizView.dispose();
        }
    }
    public void addQuestion(String type, String question, String answer){
        switch (type) {
            case "Short Answer":
                type = "short";
                break;
            case "Fill In Blank":
                type = "fill";
                break;
            case "True or False":
                type = "tf";
                break;
            default:
                break;
        }
        AddQuestion addQuestion = new AddQuestion(fileName);
        addQuestion.addQuestion(type, question, answer);
    }
}
