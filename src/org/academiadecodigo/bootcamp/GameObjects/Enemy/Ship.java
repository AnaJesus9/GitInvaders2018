package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.CreateObject
import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Position;
import org.academiadecodigo.bootcamp.GameObjects.Bullet;

public class Ship extends Enemy {

    private CreateObject object;

    public Ship( Position position){
        super(position);
        this.object = new CreateObject(position.getRow(), position.getCol());
    }

    @Override
    public void move(Directions direction) {
        getPosition().move(direction, 1);
        object.move(direction, 1);
    }

    @Override
    public void hit(int damage) {

        setHealth(getHealth() - damage);

        if(getHealth() == 0){
            setDestroyed(true);

            getPosition().hide();
        }

    }


    @Override
    public Bullet shoot() {
        return new Bullet();
    }

}