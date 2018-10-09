package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.bootcamp.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp.GameObjects.Shootable;

public abstract class Enemy extends GameObjects implements Shootable {

    private CreateObject object;
    private int health;
    private boolean destroyed;
    private int damage;


    public Enemy(CreateObject object){
        this.health = 100;
        this.destroyed = false;
        this.object = object;

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

    public Position getPosition() {
        return object.getPo();
    }

    //public void setPosition(Position position) {
        //this.position = position;
    //}


}
