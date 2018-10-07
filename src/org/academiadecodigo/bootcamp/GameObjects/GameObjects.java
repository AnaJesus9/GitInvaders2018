package org.academiadecodigo.bootcamp.GameObjects;
import org.academiadecodigo.bootcamp.GameEngine.*;
public abstract class GameObjects {

    public abstract void move(Directions direction);

    public abstract void hit(int damage);

    public abstract boolean isDestroyed();
}
