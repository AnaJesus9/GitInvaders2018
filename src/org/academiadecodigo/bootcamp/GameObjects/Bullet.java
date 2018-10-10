package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public class Bullet extends GameObjects {

    private int damage;
    private Graphics object;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target) {

        this.damage = 1;
        this.object = new Graphics(position.getRow(),0, 1);
        this.object.init();
        this.destroyed = false;
        this.target = target;

        move(Directions.RIGHT);
    }

    public void move(Directions direction) {
        try {
            if(!(object.getPo().getCol() == 21)){
                object.move(direction, 1);
                return;
            }
            destroyed();
        } catch (Exception e) {
            System.out.println("Bullet move");
        }

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
}
