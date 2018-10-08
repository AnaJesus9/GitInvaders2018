package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.Menu.Menu;

public class TestMenu {
    public static void main(String[] args) throws Exception {

        EngineFactory.field();
        Menu u = new Menu(14,14);
        u.init();
        Thread.sleep(2500);
        u.delete();

    }
}
