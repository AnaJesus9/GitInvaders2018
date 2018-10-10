package org.academiadecodigo.bootcamp.GameEngine.Direction;

public enum Directions {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static Directions getOpposite(Directions direction) {
        switch (direction) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case RIGHT:
                return LEFT;
            case LEFT:
                return RIGHT;
            default:
                return direction;
        }
    }
}
