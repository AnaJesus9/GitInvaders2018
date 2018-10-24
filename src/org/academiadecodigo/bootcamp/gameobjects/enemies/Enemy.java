package org.academiadecodigo.bootcamp.gameobjects.enemies;

import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.bootcamp.gameengine.sprites.Explosion;
import org.academiadecodigo.bootcamp.gameengine.sprites.Sprite;
import org.academiadecodigo.bootcamp.gameengine.utils.Random;
import org.academiadecodigo.bootcamp.gameengine.utils.ResourcePath;
import org.academiadecodigo.bootcamp.gameobjects.Bullet;
import org.academiadecodigo.bootcamp.gameobjects.GameObject;
import org.academiadecodigo.bootcamp.gameobjects.Shooter;

public abstract class Enemy extends GameObject implements Shooter {

    private Direction direction;
    private int movesInDirection;
    private Bullet[] bullets = new Bullet[100];
    protected Type shooterType;

    public Enemy(Sprite sprite) {

        this.destroyed = false;
        this.sprite = sprite;
        this.movesInDirection = GameConfigs.CELL_SIZE * 2;
        this.direction = Direction.LEFT;
        this.shooterType = Type.ENEMY;
    }

    @Override
    public void move(Direction direction) {

        if (isDestroyed()) {
            return;
        }
        animate();
        getRandomShot();

        if (movesInDirection == 0) {
            this.direction = getRandomDirection();
        }
        direction = this.direction;
        sprite.move(direction, 1);
        movesInDirection--;

    }

    @Override
    public void shoot() {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].isDestroyed()) {
                bullets[i] = null;
            }
            if (bullets[i] == null) {
                bullets[i] = new Bullet(sprite.getPosition(), shooterType, ResourcePath.ENEMY_BULLETS);
                break;
            }
        }
    }

    public void moveBullet() {
        for (Bullet bullet : bullets) {
            if (bullet != null && bullet.isDestroyed()) {
                continue;
            }
            if (bullet != null) {
                bullet.move(Direction.LEFT);
            }
        }
    }

    private void getRandomShot() {
        int random = Random.getRandomNumberWithZero(20);

        if (movesInDirection == 40 || movesInDirection == 0) {
            if (random == 3) {
                shoot();
            }
        }
    }

    private Direction getRandomDirection() {
        int random = Random.getRandomNumber(2);

        if (random != 2) {
            movesInDirection = GameConfigs.CELL_SIZE * 2;
            return Direction.LEFT;
        }

        movesInDirection = GameConfigs.CELL_SIZE;
        return Direction.values()[Random.getRandomNumberWithZero(3)];
    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        destroyBullets();
        getSprite().hide();
        Explosion explosion = new Explosion(sprite.getPosition(), 7);
        explosion.explode();
        this.destroyed = true;
    }

    private void destroyBullets() {
        for (Bullet bullet : bullets) {
            if (bullet == null) {
                continue;
            }
            bullet.destroy();
        }
    }

    private void animate() {
        sprite.hide();
        sprite.show();
    }

    public Direction getDirection() {
        return direction;
    }

    public Bullet[] getBullets() {
        return this.bullets;
    }

    public Sprite getSprite() {
        return this.sprite;
    }
}
