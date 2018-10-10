package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.GameObjects.Enemy.Ship;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Game implements KeyboardHandler {
    private Player player;
    private final int NUMBER_OF_ENEMIES = 3;
    private Ship[] enemies = new Ship[NUMBER_OF_ENEMIES];

    private Keyboard keyboard;

    public Game(){
        player = new Player();
        this.keyboard = new Keyboard(this);
        implementKeys();
        createEnemies();

    }
    //Create enemy instances and add to the array
    private void createEnemies(){
        for( int i = 0; i < NUMBER_OF_ENEMIES; i++){
            this.enemies[i] = new Ship();
        }
    }
    private boolean checkEnemies(){
        for( int i = 0; i < NUMBER_OF_ENEMIES; i++){
            if( !enemies[i].isDestroyed()){ //return false if there is at least one enemy still alive
                return false;
            }
        }
        return true; //return true is all enemies are destroyed
    }

    public void start(){
        while(true){

            for(  Ship enemy : enemies){
                enemy.move();
            }

            checkCollisions();
        }
    }

    public void checkCollisions(){

        for(GameObjects enemy : enemies){
            if( enemy.isDestroyed()){
                continue;
            }
            for(Bullet bullet : player.getBullets()){
                if( bullet != null){
                    if(bullet.isDestroyed()){
                        continue;
                    }

                    if( compare(enemy,bullet) ){
                        enemy.hit();
                        bullet.destroyed();
                    }
                }
            }
        }

    }

    public boolean compare(GameObjects enemy, Bullet bullet){
        return (enemy.getGraphics().getPo().getCol() == bullet.getGraphics().getPo().getCol() &&
                enemy.getGraphics().getPo().getRow() == bullet.getGraphics().getPo().getRow());
    }

    private void implementKeys(){
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
        this.keyboard.addEventListener(space);
    }

    public void keyPressed(KeyboardEvent e){
        switch (e.getKey()){
            case KeyboardEvent.KEY_UP: player.move(Directions.UP);
                break;
            case KeyboardEvent.KEY_DOWN: player.move(Directions.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE: player.shoot();
                break;
        }

    }

    public void keyReleased(KeyboardEvent e){

    }


}
