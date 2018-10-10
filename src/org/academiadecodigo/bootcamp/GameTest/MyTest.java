package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        EngineFactory.field();
        CreateObject ship = new CreateObject(0,0,1);
        ship.init();
        while(true) {
            Thread.sleep(25);
            //ship.move(Directions.LEFT);
            System.out.println(ship.getPo().getRow() + " ROW");
            System.out.println(ship.getPo().getCol() + " COL");
        }
    }
}
