package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;

public class TestGame {

    public static void main(String[] args) {
        EngineFactory.field();
        Game g = new Game();

        g.start();
    }
}
