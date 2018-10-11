package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameObjects.Enemy.Enemy;

public class Bullet extends GameObjects {

    private Graphics object;
    private boolean destroyed;
    private GameObjects shooter;

    public Bullet(Position position, GameObjects shooter, int resource) {

        this.object = new Graphics(position.getRow(),position.getCol(), resource);
        this.destroyed = false;
        this.shooter = shooter;
    }

    public void move(Directions direction) {

        if(isDestroyed()) {
            return;
        }
        if(object.getPo().getCol() == 0 && shooter instanceof Enemy ||
                object.getPo().getCol() == GameConfigs.COL -1 && shooter instanceof Player ) {
            destroyed();
            return;
        }
        if(!(object.getPo().getCol() == GameConfigs.COL-1) || !(object.getPo().getCol() == 0)){
            object.move(direction, 10);
            return;
        }
    }

    public void hit() {
        getGraphics().hide();
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
    public Graphics getGraphics(){
        return this.object;
    }
}
