// NAME: JEET AGRAWAL
// NSID: jea316
// STUDENT ID: 11269096
package com.example.a1;

import javafx.scene.paint.Color;

public class ColorPalette {
    Color c1;
    Color c2;
    Color c3;

    public void addColor(Color c, Integer i){

        if (i == 0) c1 = c;
        if (i == 1) c2 = c;
        if (i == 2) c3 = c;

    }
    public String toString(){

        return String.valueOf((int)(c1.getRed()*255))+","+String.valueOf((int)(c1.getGreen()*255))+","+String.valueOf((int)(c1.getBlue()*255))+ "\n"+
                String.valueOf((int)(c2.getRed()*255))+","+String.valueOf((int)(c2.getGreen()*255))+","+String.valueOf((int)(c2.getBlue()*255))+ "\n"+
                String.valueOf((int)(c3.getRed()*255))+","+String.valueOf((int)(c3.getGreen()*255))+","+String.valueOf((int)(c3.getBlue()*255))+ "\n";
    }
}
