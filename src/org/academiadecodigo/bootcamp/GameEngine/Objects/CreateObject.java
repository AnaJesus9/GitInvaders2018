package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Direction;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CreateObject extends Direction {

    private Position po;
    private Picture object;
    private String[] resource = {"resources/player.png", "resources/enemy.png"};
    private int resources;
    private int pixelCounter;

    public CreateObject(double row, double col, int resources){
        this.po = new Position(row, col);
        this.resources = resources;
        this.pixelCounter = 0;
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

    public void move(Directions direction) {

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

    public void moveDirection(int col, int row) {
        //Thread.sleep(1);
        //object.delete();
        object.translate(col,row);
        object.draw();
        pixelCounter++;
        if(pixelCounter == GameConfigs.CELLSIZE) {
            po.setCol(po.getCol() + col);
            po.setRow(po.getRow() + row);
            pixelCounter = 0;
        }
    }

    public Position getPo(){
        return po;
    }

}
