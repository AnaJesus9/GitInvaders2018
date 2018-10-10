/**package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.GameObjects.*;

import java.util.LinkedList;

public class Game {
    private Player player;
    private final int NUMBER_OF_ENEMIES = 10;
    private GameObjects[] gameObjects;
    private LinkedList<Bullet> bullets;

    public Game(){
        player = new Player();

        createEnemies();

    }
    //Create enemy instances and add to the array
    private void createEnemies(){
        for( int i = 0; i < NUMBER_OF_ENEMIES; i++){
            //this.gameObjects[i] = ObjectFactory.getNewEnemy();
        }
    }
    private boolean checkEnemies(){
        for( int i = 0; i < NUMBER_OF_ENEMIES; i++){
            if( !gameObjects[i].isDestroyed()){ //return false if there is at least one enemy still alive
                return false;
            }
        }
        return true; //return true is all enemies are destroyed
    }

    public void start(){
        while( !player.isDestroyed() || !checkEnemies()){
            //Enemy movements

            //Enemy fire (Needs to consider if all enemies will fire or enemies fire randomly)

            //Check collisions
        }
    }



}
*/