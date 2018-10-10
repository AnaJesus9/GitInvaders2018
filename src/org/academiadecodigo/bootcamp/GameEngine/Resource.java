package org.academiadecodigo.bootcamp.GameEngine;

public enum Resource {
    ENEMY("resources/enemies.png"),
    PLAYER("resources/player.png"),
    BULLET("resources/te.png");

   private String path;

    Resource(String s){
        this.path = s;
    }

    public String getPath(){
        return path;
    }

}
