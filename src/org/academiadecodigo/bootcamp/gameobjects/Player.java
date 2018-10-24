package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.field.Position;
import org.academiadecodigo.bootcamp.gameengine.sprites.Explosion;
import org.academiadecodigo.bootcamp.gameengine.sprites.Life;
import org.academiadecodigo.bootcamp.gameengine.sprites.Sprite;
import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.bootcamp.gameengine.utils.ResourcePath;

public class Player extends GameObject implements Shooter {

    private Life[] lives;
    private int numbOfLives;
    private Bullet[] bullets = new Bullet[5];
    protected Type shooterType;

    public Player() {
        this.sprite = new Sprite(5, 0, ResourcePath.PLAYER);
        this.numbOfLives = 4;
        this.lives = new Life[numbOfLives];
        this.destroyed = false;
        this.shooterType = Type.PLAYER;
        drawLives();
    }

    public void move(Direction direction) {
        sprite.move(direction, GameConfigs.SPEED_PLAYER);
    }

    private void drawLives() {
        int col = 0;
        for (int i = 0; i < numbOfLives; i++) {
            lives[i] = new Life(col);
            col += 1;
        }
    }

    public void animate() {
        sprite.hide();
        sprite.show();
        animateLives();

    }

    public void shoot() {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].isDestroyed()) {
                bullets[i] = null;
            }

            if (bullets[i] == null) {
                bullets[i] = new Bullet(getPosition(), shooterType, ResourcePath.BULLET);
                break;
            }
        }
    }

    public void moveBullet() {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].isDestroyed()) {
                continue;
            }
            if (bullets[i] != null) {
                bullets[i].move(Direction.RIGHT);
            }
        }
    }

    public void hit() {
        if (numbOfLives == 0) {
            return;
        }
        numbOfLives--;
        lives[numbOfLives].hide();
        for (int i = 0; i < 50; i++) {
            sprite.hide();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sprite.show();
        }
        if (numbOfLives == 0) {
            sprite.hide();
            Explosion explosion = new Explosion(getPosition(), 30);
            explosion.explode();
            destroyed = true;
        }
    }

    private void animateLives() {
        for (int i = 0; i < numbOfLives; i++) {
            lives[i].hide();
            lives[i].show();
        }
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    private Position getPosition() {
        return sprite.getPosition();
    }

    public Bullet[] getBullets() {
        return this.bullets;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

}
