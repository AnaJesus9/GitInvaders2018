package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp.GameObjects.Shootable;

public abstract class Enemy extends GameObjects implements Shootable {

    private Position position;
    private int health;
    private boolean destroyed;

    public Enemy(Position position){
        this.health = 100;
        this.destroyed = false;
        this.position = new Position();

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }



}
