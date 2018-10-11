package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Life;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public class Player extends GameObjects implements Shootable {
    private Graphics object;
    private int damage;
    private Life[] lives;
    private int numbOfLives;
    private boolean destroyed;
    private Bullet[] bullets = new Bullet[100];


    public Player(){
        this.object = new Graphics(5, 0,0); //Requires implemented position class to add proper parameters
        this.damage = 1;
        this.numbOfLives = 4;
        this.lives = new Life[numbOfLives];
        this.destroyed = false;
        drawLives();
    }

    public void move(Directions direction) {
        object.move(direction, 40);
    }

    private void drawLives(){
        double col = 0.2;
        for(int i = 0; i < numbOfLives; i++){
            lives[i] = new Life(col);
            col += 0.7;
        }
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
        numbOfLives--;
        lives[numbOfLives].hide();
        for(int i = 0; i < 50; i++){
            object.hide();
            try {
                Thread.sleep(1);
            }catch (Exception e){
                System.out.println("error delay");
            }
            object.show();
        }
        if(numbOfLives == 0){
            destroyed = true;
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
