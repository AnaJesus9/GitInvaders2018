package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.GeneratePosition;

public class Ship extends Enemy {

    public Ship( GeneratePosition position){
        super(position);
    }

    @Override
    public void move(Directions direction) {
        getPosition().movePosition(direction, 1);
    }

    @Override
    public void hit() {
        if(getHealth() == 0){
            setDestroyed(true);
        }

    }


    @Override
    public void shoot() {

    }

}