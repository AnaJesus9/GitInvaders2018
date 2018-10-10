package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Resource;

public class Bullet extends GameObjects {

    private int damage;
    private Graphics object;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target) {

        this.damage = 1;
        this.object = new Graphics(position.getRow(),0, Resource.ENEMY);
        this.object.init();
        this.destroyed = false;
        this.target = target;

        move(Directions.RIGHT);
    }

    public void move(Directions direction) {
        if(!(object.getPo().getCol() == GameConfigs.COL-1)){
            object.move(direction, 1);
            return;
        }
        destroyed();
    }

    public void hit(int damage) {
        this.damage = damage;
        this.destroyed = true;
    }

    public void destroyed() {
        object.hide();
        this.destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public Graphics getGraphics() {
        return this.object;
    }
}
