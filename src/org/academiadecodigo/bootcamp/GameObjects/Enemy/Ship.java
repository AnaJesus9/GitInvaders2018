package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.bootcamp.GameObjects.Bullet;

public class Ship extends Enemy {

    private CreateObject object;

    public Ship( CreateObject position){
        super(position);
        this.object = new CreateObject(5, 2, 1);
    }

    @Override
    public void move(Directions direction) {
        object.move(direction);
        object.move(direction);
    }

    @Override
    public void hit(int damage) {

        setHealth(getHealth() - damage);

        if(getHealth() == 0){
            setDestroyed(true);

            object.hide();
        }

    }


    @Override
    public Bullet shoot() {
        return new Bullet();
    }

}