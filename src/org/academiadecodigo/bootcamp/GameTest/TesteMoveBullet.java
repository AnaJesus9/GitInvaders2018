package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameObjects.Player;

public class TesteMoveBullet {
    public static void main(String[] args) {
        EngineFactory.field();

        try {
            teste();
        }catch (Exception e){
            System.out.println("teste");
        }

    }

    public static void teste() throws Exception{
        Player p = new Player();
        while (true){
            Thread.sleep(1);
            p.moveBullet();
        }
    }
}
