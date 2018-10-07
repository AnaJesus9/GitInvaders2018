package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GeneratePosition{

    public int row;
    public int col;
    public int CELLSIZE = 10;
    public Rectangle field;

    public GeneratePosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void init(){
        this.field = new Rectangle(col,row,CELLSIZE,CELLSIZE);
        this.field.fill();
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

}
