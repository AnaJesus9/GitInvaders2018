package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObjects implements Shootable, KeyboardHandler {
    private GeneratePosition position;
    private int damage;
    private int lives;
    private boolean destroyed;

    private Keyboard keyboard;

    public Player(){
        this.position = new GeneratePosition(5, 0); //Requires implemented position class to add proper parameters
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;

        implementKeys();
    }

    public void move(Directions direction){
        getPosition().movePosition(direction, 1);

    }

    public Bullet shoot(){
        return new Bullet( this.getPosition(), this);
    }


    public void hit(int damage){
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

        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
        this.keyboard.addEventListener(space);
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


    public GeneratePosition getPosition(){
        return this.position;
    }

}
