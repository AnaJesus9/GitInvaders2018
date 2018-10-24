package org.academiadecodigo.bootcamp.gameobjects.enemies;

import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.bootcamp.gameengine.sprites.Sprite;
import org.academiadecodigo.bootcamp.gameengine.utils.Random;
import org.academiadecodigo.bootcamp.gameengine.utils.ResourcePath;


public class Ship extends Enemy {

    public Ship() {
        super(new Sprite(Random.getRandomNumberWithZero(GameConfigs.CANVAS_ROW_SIZE - 2) + 1,
                GameConfigs.CANVAS_COL_SIZE - 1, ResourcePath.ENEMY));
    }

    public void move() {
        move(getDirection());
    }

    public void hit() {
        setDestroyed();
    }

    public Sprite getSprite() {
        return super.getSprite();
    }
}