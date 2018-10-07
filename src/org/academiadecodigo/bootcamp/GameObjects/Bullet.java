package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameEngine.Directions;

import javax.swing.text.Position;

public class Bullet extends Game {

    private int damage;
    private Position position;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target){
        this.damage = 1;
        this.position = position;
        this.destroyed = false;
        this.target = target;
    }

    public void move(Directions direction){
        position.movePosition(direction, 1);
    }
    public void hit(int damage){
        this.damage = damage;
        this.destroyed = true;
    }

    public boolean isDestroyed(){
        return this.destroyed;
    }
}
