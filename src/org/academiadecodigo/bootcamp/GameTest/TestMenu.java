package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.Menu.Menu;

public class TestMenu {
    public static void main(String[] args) throws Exception {

        EngineFactory.field();
        Menu u = new Menu(14,14);
        u.init();
        Thread.sleep(4500);
        u.delete();

    }
}
