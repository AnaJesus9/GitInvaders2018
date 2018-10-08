package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CreateObject {

    private Position po;
    private Rectangle object;

    public CreateObject(double row, double col){
        this.po = new Position(row, col);
    }

    public void init(){
        this.object = new Rectangle(po.getWidth(),po.getHeight(),po.getCELLSIZE(),po.getCELLSIZE());
        this.object.fill();
    }

    public void hide(){
        object.delete();
    }

    public void show(){
        object.draw();
    }

    public void move(Directions direction) throws Exception{
        switch (direction){
            case UP:
                moveDirection(0, -1);
                break;
            case DOWN:
                moveDirection(0, 1);
                break;
            case LEFT:
                moveDirection(-1, 0);
                break;
            case RIGHT:
                moveDirection(1, 0);
                break;
        }
    }

    private void moveDirection(int x, int y) throws Exception{
        Thread.sleep(1);
        object.delete();
        object.translate(x,y);
        object.fill();
    }

}
