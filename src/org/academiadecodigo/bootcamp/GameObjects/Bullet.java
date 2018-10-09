package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;

import javax.swing.text.Position;

public class Bullet extends Game {

    private int damage;
    private CreateObject object;
    private boolean destroyed;
    private GameObjects target;

    public Bullet(Position position, GameObjects target){
        this.damage = 1;
        this.object = new CreateObject(position.getRow(), position.getCol(),1);
        this.destroyed = false;
        this.target = target;
    }

    public void move(Directions direction){
        object.move(direction);
    }

    public void hit(int damage){
        this.damage = damage;
        this.destroyed = true;
    }

    public boolean isDestroyed(){
        return this.destroyed;
    }
}
