package org.academiadecodigo.bootcamp.gameobjects;

public interface Shooter {

     void shoot();

     enum Type {
         ENEMY,
         PLAYER
     }
}
