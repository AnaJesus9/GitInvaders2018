package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Random;
import org.academiadecodigo.bootcamp.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp.GameObjects.Shootable;

public abstract class Enemy extends GameObjects implements Shootable {

    private Graphics object;
    private int health;
    private boolean destroyed;
    private Directions direction;
    private int timesToMove;


    public Enemy(Graphics object){
        this.health = 100;
        this.destroyed = false;
        this.object = object;
        this.timesToMove = GameConfigs.CELLSIZE * 2;
        this.direction = Directions.LEFT;
    }

    @Override
    public void move(Directions direction) {

        if(isDestroyed()){
            return;
        }

        if (timesToMove == 0) {
            this.direction = getRandomDirection();
        }
        direction = this.direction;
        object.move(direction, 1);
        timesToMove--;


    }

    private Directions getRandomDirection() {
        int random = Random.getRandomNumber(2);
        if(random != 2) {
            timesToMove = GameConfigs.CELLSIZE * 2;
            return Directions.LEFT;
        }
        timesToMove = GameConfigs.CELLSIZE;
        return Directions.values()[Random.getRandomNumberWithZero(3)];
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        getGraphics().hide();
        this.destroyed = true;
    }

    public Graphics getObject() {
        return object;
    }

    public Directions getDirection() {
        return direction;
    }

    public Graphics getGraphics(){
        return this.object;
    }
}
