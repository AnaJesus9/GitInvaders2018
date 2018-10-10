package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Random;

public class Ship extends Enemy {


    public Ship(){
        super(new Graphics((double)Random.getRandomNumberWithZero(GameConfigs.ROW),
                GameConfigs.COL -1,
                1));


    }


    public void move() {
        move(getDirection());
    }

    @Override
    public void hit() {

        setDestroyed(true);

        getObject().hide();

    }


    @Override
    public void shoot() {
        //return new Bullet();
    }

    public Graphics getGraphics(){
        return super.getGraphics();
    }

}