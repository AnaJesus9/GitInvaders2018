package org.academiadecodigo.bootcamp.gameengine.sprites;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private Text object;
    private int score;

    public Score(){
        score = 1;
        this.object = new Text(440,400,"WAVE " + score);
        this.object.setColor(Color.WHITE);
        this.object.draw();
    }

    public void increaseScore() {
        score++;
        object.setText("WAVE " + score) ;
    }
}
