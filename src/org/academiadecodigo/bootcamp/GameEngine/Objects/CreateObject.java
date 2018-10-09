package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Direction;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CreateObject extends Direction {

    private Position po;
    private Picture object;
    private String[] resource = {"resources/player.png", "resources/enemy.png"};
    private int resources;

    public CreateObject(double row, double col, int resources){
        this.po = new Position(row, col);
        this.resources = resources;
    }

    public void init(){
        this.object = new Picture(po.getWidth(),po.getHeight(),resource[resources]);
        this.object.draw();
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

    public void moveDirection(int x, int y) throws Exception{
        Thread.sleep(1);
        object.delete();
        object.translate(x,y);
        object.draw();
    }

}
