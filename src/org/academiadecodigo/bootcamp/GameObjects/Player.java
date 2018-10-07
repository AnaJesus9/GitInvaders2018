package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObjects implements Shootable, KeyboardHandler {
    private Position position;
    private int damage;
    private int lives;
    private boolean destroyed;

    private Keyboard keyboard;

    public Player(){
        this.position = new Position(); //Requires implemented position class to add proper parameters
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;

        implementKeys();
    }

    public void move(Directions direction){
        switch(direction){
            case UP: position.setPosition(0, -1);
                break;
            case DOWN: position.setPosition(0, 1);
                break;
        }

    }

    public void shoot(){

    }

    public void hit(){
        this.lives--;

        if(this.lives == 0){
            destroy();
        }
    }

    public boolean isDestroyed(){
        return this.destroyed;
    }

    private void destroy(){
        this.destroyed = true;
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
    }

    public void keyPressed(KeyboardEvent e){
        switch (e.getKey()){
            case KeyboardEvent.KEY_UP: move(Directions.UP);
            break;
            case KeyboardEvent.KEY_DOWN: move(Directions.DOWN);
            break;
            case KeyboardEvent.KEY_SPACE: shoot();
            break;
        }

    }

    public void keyReleased(KeyboardEvent e){

    }


}
