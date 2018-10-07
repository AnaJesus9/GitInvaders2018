package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.GeneratePosition;
import org.academiadecodigo.bootcamp.GameObjects.Bullet;

public class Ship extends Enemy {

    public Ship( GeneratePosition position){
        super(position);
    }

    @Override
    public void move(Directions direction) {
        getPosition().movePosition(direction, 1);
    }

    @Override
    public void hit(int damage) {

        setHealth(getHealth() - damage);

        if(getHealth() == 0){
            setDestroyed(true);

            getPosition().hide();
        }

    }


    @Override
    public Bullet shoot() {
        return new Bullet();
    }

}