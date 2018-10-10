package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;

public class Bullet extends GameObjects {

    private int damage;
    private CreateObject object;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target) {
        this.damage = 1;
        this.object = new CreateObject(position, 1);
        this.object.init();
        this.destroyed = false;
        this.target = target;
        move(Directions.RIGHT);
    }

    public void move(Directions direction) {
        try {
            object.move(direction, 6);
        } catch (Exception e) {
            System.out.println("Bullet move");
        }

    }

    public void hit(int damage) {
        this.damage = damage;
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }
}
