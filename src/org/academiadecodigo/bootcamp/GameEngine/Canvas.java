package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas extends Grid{

    public int row;
    public int col;
    public int CELLSIZE = 10;
    public Rectangle field;

    public Canvas(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void init(){
        this.field = new Rectangle(10,10,getWidth(),getHeight());
        this.field.draw();
    }

    public double getRow(){
        return row;
    }

    public double getCol(){
        return col;
    }

    public double getWidth(){
        return col * CELLSIZE;
    }

    public double getHeight(){
        return row * CELLSIZE;
    }

    public void makePosition(){

    }

}
