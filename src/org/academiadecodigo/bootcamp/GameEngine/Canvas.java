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

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getWidth(){
        return col * CELLSIZE;
    }

    public int getHeight(){
        return row * CELLSIZE;
    }

    public void makePosition(){

    }

}
