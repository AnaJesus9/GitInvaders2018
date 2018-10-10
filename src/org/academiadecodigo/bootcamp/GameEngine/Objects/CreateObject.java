package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Direction;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CreateObject extends Direction {

    private Position po;
    private Picture object;
    private String[] resource = {"resources/player.png", "resources/enemies.png"};
    private int resources;

    public CreateObject(double row, double col, int resources){
        this.po = new Position(row, col);
        this.resources = resources;
        init();
    }

    public CreateObject(Position position, int resources){
        this.po = position;
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

    public void move(Directions direction, int speed) throws Exception {
        switch (direction){
            case UP:
                if(!(po.getRow() < 1)){
                    moveDirection(0, -speed);
                    movePos(speed, direction);
                }
                break;
            case DOWN:
                if(!(po.getRow() > 10)){
                    moveDirection(0, speed);
                    movePos(speed, direction);
                    break;
                }
                break;
            case LEFT:
                if(!(po.getCol() < 1)){
                    moveDirection(-speed, 0);
                    movePos(speed, direction);
                    break;
                }
                break;
            case RIGHT:
                if(!(po.getCol() > GameConfigs.COL-4)){
                    moveDirection(speed, 0);
                    movePos(speed, direction);
                    break;
                }
                break;
        }
    }

    public void moveDirection(int x, int y){
        object.delete();
        object.translate(x,y);
        object.draw();
    }

    public Position getPo(){
        return po;
    }

    private void movePos(int speed, Directions direction){
        po.movePosition(speed, direction);
    }

}
