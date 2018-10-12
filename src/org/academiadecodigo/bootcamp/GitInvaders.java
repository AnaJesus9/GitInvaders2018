package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Menu.Menu;

public class GitInvaders {

    public static void main(String[] args){
        //out
        EngineFactory.field();


        Game game = new Game();

        try{
            game.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

