package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.CreateObject;

public class Main {
    public static void main(String[] args){

        EngineFactory.field(14,14);

        EngineFactory.object(7,0.35);


        CreateObject obj = new CreateObject(7,13.35);
        obj.init();


        try {
            obj.move(Directions.LEFT,13);
        }catch (Exception e){
            System.out.printf("2");
        }

    }

}
