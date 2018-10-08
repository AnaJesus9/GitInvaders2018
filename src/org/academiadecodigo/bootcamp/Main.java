package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.CreateObject;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args){

        EngineFactory.field(14,14);

        EngineFactory.object(7,0.35);


        CreateObject obj = new CreateObject(7,11);
        obj.init();

        try {
            for(int i = 0; i < 10; i++){
                obj.move(Directions.LEFT,10);
                obj.move(Directions.UP,4);
                obj.move(Directions.RIGHT,10);
                obj.move(Directions.DOWN,4);
            }
        }catch (Exception e){
            System.out.printf("2");
        }

    }

}
