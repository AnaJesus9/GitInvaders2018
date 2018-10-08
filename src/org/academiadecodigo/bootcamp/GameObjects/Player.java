package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObjects implements Shootable, KeyboardHandler {
    private CreateObject position;
    private int damage;
    private int lives;
    private boolean destroyed;

    private Keyboard keyboard;

    public Player(){
        this.position = new CreateObject(5, 0); //Requires implemented position class to add proper parameters
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;

        implementKeys();
    }

    public void move(Directions direction){
        try{
            position.move(direction);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public Bullet shoot(){
        //return new Bullet( this.getPosition(), this);
        return null;
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
        keyboard = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
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


    public CreateObject getPosition(){
        return this.position;
    }

}
