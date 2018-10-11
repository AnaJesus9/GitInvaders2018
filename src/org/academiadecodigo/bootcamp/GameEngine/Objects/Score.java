package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private Text object;

    public Score(int score){
        this.object = new Text(440,500,"WAVE " + score);
        this.object.setColor(Color.WHITE);
        this.object.draw();
    }

    public void update(int score) {
        object.setText("WAVE " + score) ;
    }

    public void hide(){
        object.delete();
    }

    public void show(){
        object.draw();
    }
}
