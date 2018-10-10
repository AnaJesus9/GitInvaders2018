package org.academiadecodigo.bootcamp.GameTest;

import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;

public class TestMove {
    public static void main(String[] arg) {

        EngineFactory.field();

        EngineFactory.object(6,0.35, 0);


        CreateObject[] obj = {new CreateObject(2,20,1),new CreateObject(4,20,1),new CreateObject(6,20,1 ), new CreateObject(8,20,1), new CreateObject(10,20,1)};

        obj[0].init();
        obj[1].init();
        obj[2].init();
        obj[3].init();
        obj[4].init();

        try {
            for(int u = 0; u < 500; u++){
                for (int e = 0; e < 15*40; e++){
                    for(int i = 0; i < obj.length; i++){
                        obj[i].move(Directions.LEFT,2);
                    }
                }
                for (int e = 0; e < 15*40; e++){
                    for(int i = 0; i < obj.length; i++){
                        obj[i].move(Directions.RIGHT,2);
                    }
                }
            }
        }catch (Exception e){
            System.out.printf("2");
        }
    }
}
