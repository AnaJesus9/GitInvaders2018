package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public class Player extends GameObjects implements Shootable {
    private Graphics object;
    private int damage;
    private int lives;
    private boolean destroyed;
    private Bullet[] bullets = new Bullet[100];


    public Player(){
        this.object = new Graphics(5, 0,0); //Requires implemented position class to add proper parameters
        this.damage = 1;
        this.lives = 3;
        this.destroyed = false;
    }

    public void move(Directions direction) {
        object.move(direction, 40);
    }

    public void shoot(){
        for(int i = 0; i < bullets.length; i++){
            if( bullets[i] != null && bullets[i].isDestroyed()){
                bullets[i] = null;
            }

            System.out.println(i);
            if(bullets[i] == null){
                bullets[i] = new Bullet( new Position(getPosition().getRow(), 0), this, 2);
                break;
            }
        }
    }

    public void moveBullet(){
        for(int i = 0; i < bullets.length; i++){
            if(bullets[i] != null && bullets[i].isDestroyed()) {
                continue;
            }
            if(bullets[i] != null){
                bullets[i].move(Directions.RIGHT);
            }
        }
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
