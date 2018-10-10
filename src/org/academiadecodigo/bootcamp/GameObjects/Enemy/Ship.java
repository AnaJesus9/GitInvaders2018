package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.bootcamp.GameEngine.Random;
import org.academiadecodigo.bootcamp.GameObjects.Bullet;

public class Ship extends Enemy {


    public Ship(){
        super(new CreateObject((double)Random.getRandomNumberWithZero(GameConfigs.ROW),
                GameConfigs.COL -1,
                1));


    }


    public void move() {
        move(getDirection());
    }

    @Override
    public void hit(int damage) {

        setHealth(getHealth() - damage);

        if(getHealth() == 0){
            setDestroyed(true);

            getObject().hide();
        }

    }


    @Override
    public Bullet shoot() {
        //return new Bullet();
        return null;
    }

}