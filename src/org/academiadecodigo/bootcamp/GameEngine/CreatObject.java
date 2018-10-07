package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CreatObject {

    private Position po;
    private Rectangle object;

    public CreatObject(double row, double col){
        this.po = new Position(row, col);
    }

    public void init(){
        this.object = new Rectangle(po.getWidth(),po.getHeight(),po.getCELLSIZE(),po.getCELLSIZE());
        this.object.fill();
    }

    public void hide(){
        object.delete();
    }

    public void move() throws Exception{
        for(int i = 0; i < 10; i++){
            Thread.sleep(250);
            object.translate(-1,0);
        }
    }

}
