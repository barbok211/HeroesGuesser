/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.mtp.i4.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehdi <your.name at your.org>
 */
public class Character {
    private String name;
    private List<Attribute> attributes;
    private String imageRealtivePath;
 
    public Character(String n){
        name = n;
        attributes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    
    public void addAttribute(Attribute a){
        attributes.add(a);
    }

    public String getImageRealtivePath() {
        return imageRealtivePath;
    }

    public void setImageRealtivePath(String imageRealtivePath) {
        this.imageRealtivePath = imageRealtivePath;
    }
}
