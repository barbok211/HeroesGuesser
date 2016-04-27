/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.mtp.i4.models;

/**
 *
 * @author mehdi <your.name at your.org>
 */
public class Attribute {
    private Question question;
    private boolean response;

    public Attribute(Question q, boolean r){
        this.question = q;
        this.response = r;
    }
    
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
    
    
}
