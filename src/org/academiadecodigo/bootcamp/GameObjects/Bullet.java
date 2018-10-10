package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public class Bullet extends GameObjects {

    private int damage;
    private Graphics object;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target, int resource) {
        this.damage = 1;
        this.object = new Graphics(position.getRow(),0, resource);
        this.destroyed = false;
        this.target = target;

        move(Directions.RIGHT);
    }

    public void move(Directions direction) {
        if(isDestroyed()) {
            return;
        }
           if(!(object.getPo().getCol() == GameConfigs.COL-1)){
               object.move(direction, 10);
               return;
           }
           destroyed();
    }

    public void hit() {
        getGraphics().hide();
        this.destroyed = true;
    }

    public void destroyed() {
        object.hide();
        this.destroyed = true;
        System.out.println("destroyed");
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public Graphics getGraphics(){
        return this.object;
    }
}
