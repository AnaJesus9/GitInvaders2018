package org.academiadecodigo.bootcamp.gameengine.field;


import org.academiadecodigo.bootcamp.gameengine.utils.Converter;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Position clonePosition(Position position) {
        return new Position(position.getRow(), position.getCol());
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getX() {
        return Converter.coordinateToPixel(col);
    }

    public int getY() {
        return Converter.coordinateToPixel(row);
    }

    public void movePosition(Direction direction) {

        switch (direction) {
            case UP:
                row = row - 1;
                break;
            case DOWN:
                row = row + 1;
                break;
            case LEFT:
                col = col - 1;
                break;
            case RIGHT:
                col = col + 1;
                break;
        }
    }
}
