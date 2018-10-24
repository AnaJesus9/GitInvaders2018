package org.academiadecodigo.bootcamp.gameengine.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    public Picture[] canvas;
    private int currentPic;

    public void init() {
        canvas = new Picture[39];
        currentPic = 0;
        for (int i = 0; i < canvas.length; i++) {
            int picNumber = i + 1;
            canvas[i] = new Picture(0, 0, "resources/background/bg (" + picNumber + ").jpg");
        }
        canvas[0].draw();
    }

    public void animate() {
        canvas[currentPic].delete();
        currentPic++;
        if (currentPic >= canvas.length) {
            currentPic = 0;
        }
        canvas[currentPic].draw();
    }
}
