package org.academiadecodigo.bootcamp.gameengine.sprites;

import org.academiadecodigo.bootcamp.gameengine.field.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion {

    private Position position;
    private Picture object;
    private String[] resource = {"resources/explosion/1.png", "resources/explosion/2.png", "resources/explosion/3.png", "resources/explosion/4.png"};
    private int delay;

    public Explosion(Position position, int delay) {
        this.delay = delay;
        this.position = Position.clonePosition(position);
    }

    public void loopImage() {
        for (int i = 0; i < 4; i++) {
            this.object.draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.object.delete();
            this.object = new Picture(position.getX(), position.getY(), resource[i]);
        }
    }

    public void explode() {
        this.object = new Picture(position.getX(), position.getY(), resource[0]);
        loopImage();
    }
}

