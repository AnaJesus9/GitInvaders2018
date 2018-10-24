package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.field.Position;
import org.academiadecodigo.bootcamp.gameengine.sprites.Sprite;
import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;

public class Bullet extends GameObject {

    private Shooter.Type shooterType;

    public Bullet(Position position, Shooter.Type shooterType, String spritePath) {

        int xOffset = shooterType == Shooter.Type.PLAYER ? 1 : -1 ;
        this.sprite = new Sprite(position.getRow(), position.getCol() + xOffset, spritePath);
        this.destroyed = false;
        this.shooterType = shooterType;
    }

    public void move(Direction direction) {

        if (isDestroyed()) {
            return;
        }

        animate();

        if (!(sprite.getPosition().getCol() == GameConfigs.CANVAS_COL_SIZE - 2) && !(sprite.getPosition().getCol() == 0)) {
            sprite.move(direction, GameConfigs.SPEED_BULLET);
            return;
        }

        destroy();
    }

    public void hit() {
        getSprite().hide();
        this.destroyed = true;
    }

    public void animate() {
        sprite.hide();
        sprite.show();
    }

    public void destroy() {
        sprite.hide();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public Sprite getSprite() {
        return this.sprite;
    }
}
