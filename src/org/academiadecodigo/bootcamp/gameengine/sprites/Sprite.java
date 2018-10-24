package org.academiadecodigo.bootcamp.gameengine.sprites;

import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.field.Position;
import org.academiadecodigo.bootcamp.gameengine.utils.Converter;
import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sprite {

    private Position position;
    private Picture texture;

    public Sprite(int row, int col, String spritePath) {
        this.position = new Position(row, col);
        this.texture = new Picture(position.getX(), position.getY(), spritePath);
        this.texture.draw();
    }

    public void hide() {
        texture.delete();
    }

    public void show() {
        texture.draw();
    }

    public void move(Direction direction, int speed) {
        switch (direction) {
            case UP:
                if (!(position.getRow() < 2)) {
                    moveTexture(0, -speed);
                    if (!(Converter.pixelToCoordinate(texture.getY()) == position.getRow())) {
                        movePosition(direction);
                    }
                }
                break;
            case DOWN:
                if (!(position.getRow() >= GameConfigs.CANVAS_ROW_SIZE - 2)) {
                    moveTexture(0, speed);
                    if (!(Converter.pixelToCoordinate(texture.getY()) == position.getRow())) {
                        movePosition(direction);
                    }
                    break;
                }
                break;
            case LEFT:
                if (!(position.getCol() < 1)) {
                    moveTexture(-speed, 0);
                    if (!(Converter.pixelToCoordinate(texture.getX()) == position.getCol())) {
                        movePosition(direction);
                    }
                    break;
                }
                break;
            case RIGHT:
                if (!(position.getCol() >= GameConfigs.CANVAS_COL_SIZE - 2)) {
                    moveTexture(speed, 0);
                    if (!(Converter.pixelToCoordinate(texture.getX()) == position.getCol())) {
                        movePosition(direction);
                    }
                    break;
                }
                break;
        }
    }

    private void moveTexture(int x, int y) {
        texture.translate(x, y);
    }

    public Position getPosition() {
        return position;
    }

    private void movePosition(Direction direction) {
        position.movePosition(direction);
    }

}
