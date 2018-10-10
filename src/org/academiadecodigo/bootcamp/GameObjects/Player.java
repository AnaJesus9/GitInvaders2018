package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObjects implements Shootable, KeyboardHandler {
    private CreateObject object;
    private int damage;
    private int lives;
    private boolean destroyed;

    private Keyboard keyboard;

    public Player(){
        this.object = new CreateObject(5, 0,0); //Requires implemented position class to add proper parameters
        this.object.init();
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;
        this.keyboard = new Keyboard(this);
        implementKeys();
    }

    public void move(Directions direction) {
        try {
            object.move(direction, GameConfigs.VELOCITY_PLAYER);
        }catch (Exception ey){
            System.out.println("Error player move");
        }
    }

    public Bullet shoot(){
        return new Bullet( getPosition(), this);
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
            case KeyboardEvent.KEY_SPACE:
                System.out.println("teste");
                shoot();
            break;
        }

    }

    public void keyReleased(KeyboardEvent e){

    }


    public Position getPosition(){
        return object.getPo();
    }

}
