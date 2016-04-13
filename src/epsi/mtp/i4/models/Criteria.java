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
public class Criteria {
    private int id;
    private int value;
    private String question;
    
    public Criteria(int i, int v, String q){
        id = i;
        value = v;
        question = q;
    }
}
