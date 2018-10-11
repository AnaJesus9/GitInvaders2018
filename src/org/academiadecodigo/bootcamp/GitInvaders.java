package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;

public class GitInvaders {

    public static void main(String[] args){

        EngineFactory.field();
        Game game = new Game();
        try{
            game.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

