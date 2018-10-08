package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.CreateObject;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args){

        EngineFactory.field(14,14);

        //EngineFactory.object(7,0.35);


        CreateObject[] obj = {new CreateObject(3,11),new CreateObject(5,11),new CreateObject(7,11), new CreateObject(9,11), new CreateObject(11,11)};

        obj[0].init();
        obj[1].init();
        obj[2].init();
        obj[3].init();
        obj[4].init();

        try {
            for(int u = 0; u < 500; u++){
                for (int e = 0; e < 10*40; e++){
                    for(int i = 0; i < obj.length; i++){
                        obj[i].move(Directions.LEFT);
                    }
                }
                for (int e = 0; e < 10*40; e++){
                    for(int i = 0; i < obj.length; i++){
                        obj[i].move(Directions.RIGHT);
                    }
                }
            }
        }catch (Exception e){
            System.out.printf("2");
        }

    }

}
