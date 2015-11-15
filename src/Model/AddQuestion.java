/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takla Gerguis
 */
public class AddQuestion {
    private final String fileName;
    
    public AddQuestion(String fileName){
        this.fileName = fileName;
    }
    
    public void addQuestion(String type, String question, String answer)
    {
        PrintWriter out;
        try {
            out = 
                new PrintWriter
                    (new BufferedWriter(new FileWriter(fileName, true)));
            out.println(type);
            out.println(question);
            out.println(answer);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(AddQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
