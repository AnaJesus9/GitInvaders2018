package org.academiadecodigo.bootcamp.gameengine.sprites;

import org.academiadecodigo.bootcamp.gameengine.field.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Life {

    private Picture texture;

    public Life(int col) {
        Position position = new Position(0, col);
        String resource = "resources/life.png";
        this.texture = new Picture(position.getX(), position.getY(), resource);
        this.texture.draw();
    }

    public void hide() {
        texture.delete();
    }

    public void show() {
        texture.draw();
    }
}
