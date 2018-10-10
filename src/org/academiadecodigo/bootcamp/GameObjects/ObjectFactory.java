package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameObjects.Enemy.Enemy;
import org.academiadecodigo.bootcamp.GameObjects.Enemy.Ship;

public class ObjectFactory {


    public Enemy getNewEnemy() {

        return new Ship();
    }

    public Player getNewPlayer() {

        return new Player();
    }



}

