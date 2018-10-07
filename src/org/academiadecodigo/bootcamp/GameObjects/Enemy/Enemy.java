package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.GeneratePosition;
import org.academiadecodigo.bootcamp.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp.GameObjects.Shootable;

public abstract class Enemy extends GameObjects implements Shootable {

    private GeneratePosition position;
    private int health;
    private boolean destroyed;

    public Enemy(GeneratePosition position){
        this.health = 100;
        this.destroyed = false;
        this.position = new GeneratePosition();

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

    public GeneratePosition getPosition() {
        return position;
    }

    public void setPosition(GeneratePosition position) {
        this.position = position;
    }
}
