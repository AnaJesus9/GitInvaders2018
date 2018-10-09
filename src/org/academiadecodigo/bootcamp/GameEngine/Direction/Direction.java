package org.academiadecodigo.bootcamp.GameEngine.Direction;

public abstract class Direction {

    public abstract void move(Directions directions) throws Exception;

    public abstract void  moveDirection(int x, int y) throws Exception;
}
