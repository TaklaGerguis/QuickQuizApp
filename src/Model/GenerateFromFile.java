/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takla Gerguis
 */
public class GenerateFromFile implements GenerateDataInterface{

    private final String fileName;

    public GenerateFromFile(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Question[] generateQuestions() {
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerateFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Question> allQuestions = new ArrayList<Question>();
        while(in.hasNext()){
           String type = in.nextLine();
           String questionText = in.nextLine();
           String answer = in.nextLine();
           
           if(type.equals("tf")){
               TrueFalseQuestion question 
                       = new TrueFalseQuestion
                            (questionText, answer.equals("true")? true : false);
               allQuestions.add(question);
           }else if (type.equals("fill")){
               FillInBlankQuestion question
                       = new FillInBlankQuestion(questionText, answer);
               allQuestions.add(question);
           }else if(type.equals("short")){
               ShortAnswerQuestion question
                       = new ShortAnswerQuestion(questionText, answer);
               allQuestions.add(question);    
           }
        }
        Question[] questions = new Question[allQuestions.size()];
        return allQuestions.toArray(questions);
}
    
}
