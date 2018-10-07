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

    public void move(Directions direction, double cell) throws Exception{
        switch (direction){
            case UP:
                moveUp(cell);
                break;
            case DOWN:
                moveDown(cell);
                break;
            case LEFT:
                moveLeft(cell);
                break;
            case RIGHT:
                moveRight(cell);
                break;
        }
    }

    private void moveUp(double cell) throws Exception{
        po.setRow(po.getRow()-cell);
        for(int i = 0; i < (cell*po.getCELLSIZE()); i++){
            Thread.sleep(5);
            object.translate(0,-1);
        }
    }

    private void moveDown(double cell){
        po.setRow(po.getRow()+cell);
    }

    private void moveLeft(double cell){
        po.setCol(po.getCol()-cell);

    }

    private void moveRight(double cell){

    }

}
