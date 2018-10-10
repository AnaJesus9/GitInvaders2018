package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;

public class Main {
    public static void main(String[] args){
        EngineFactory.field();
        Game game = new Game();

        game.start();

    }

}
