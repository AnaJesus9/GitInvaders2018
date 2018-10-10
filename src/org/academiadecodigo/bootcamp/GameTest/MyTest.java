/**package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameObjects.Enemy.Ship;

public class MyTest {
    public static void main(String[] args) throws InterruptedException, Exception {
        EngineFactory.field();

        Ship shipTest = new Ship();
        Ship shipTest1 = new Ship();
        Ship shipTest2 = new Ship();
        Ship shipTest3 = new Ship();
        Ship shipTest4 = new Ship();
        Ship shipTest5 = new Ship();
        Ship shipTest6 = new Ship();
        while(true) {
            Thread.sleep(1);
            shipTest.move();
            System.out.println(shipTest.getObject().getPo().getCol() + " COL");
            System.out.println(shipTest.getObject().getPo().getRow() + " ROW");
            shipTest1.move();
            shipTest2.move();
            shipTest3.move();
            shipTest4.move();
            shipTest5.move();
            shipTest6.move();
        }
    }
}
*/