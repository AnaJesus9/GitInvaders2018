package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;

public class Main {
    public static void main(String[] args) {

        EngineFactory.field(45,80);

        EngineFactory.object(225,25);

        int row = 75;

        for(int i =0; i < 5; i++){
            EngineFactory.object(row,720);
            row += 75;
        }


    }
}
