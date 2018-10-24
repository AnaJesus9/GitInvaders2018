package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.sprites.Sprite;

public abstract class GameObject {

    protected Sprite sprite;
    protected boolean destroyed;

    public abstract void move(Direction direction);
}
