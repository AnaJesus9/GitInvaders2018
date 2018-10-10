package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Resource;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObjects implements Shootable, KeyboardHandler {
    private Graphics object;
    private int damage;
    private int lives;
    private boolean destroyed;
    private Bullet[] bullets = new Bullet[20];

    private Keyboard keyboard;

    public Player(){
        this.object = new Graphics(5, 0, Resource.PLAYER); //Requires implemented position class to add proper parameters
        this.object.init();
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;
        this.keyboard = new Keyboard(this);
        implementKeys();
    }

    public void move(Directions direction) {
        object.move(direction, 40);
    }

    public void shoot(){
        int i = 0;
        while(bullets[i] != null && i < 5){
            System.out.println(i);
            i++;
        }
        if(i < 20)
            bullets[i] = new Bullet( getPosition(), this);
    }

    public void moveBullet(){
        for(int i = 0; i < bullets.length; i++){
            if(bullets[i] != null){
                bullets[i].move(Directions.RIGHT);
                if(bullets[i].isDestroyed()){
                    bullets[i] = null;
                }
            }
        }
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


    public Position getPosition(){
        System.out.println(object.getPo().getRow());
        return object.getPo();
    }

    public Bullet[] getBullets(){
        return this.bullets;

    }

    public Graphics getGraphics(){
        return this.object;
    }

}
