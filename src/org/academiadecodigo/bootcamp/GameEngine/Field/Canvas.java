package org.academiadecodigo.bootcamp.GameEngine.Field;

import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Canvas extends GameConfigs implements Grid {

    public double row = GameConfigs.ROW;
    public double col = GameConfigs.COL;
    public int CELLSIZE = GameConfigs.CELLSIZE;
    public Rectangle field;

    public void init(){
        this.field = new Rectangle(0,0,getWidth(),getHeight());
        this.field.setColor(Color.BLACK);
        this.field.fill();
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

}
