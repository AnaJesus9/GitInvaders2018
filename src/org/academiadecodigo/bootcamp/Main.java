package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.CreatObject;

public class Main {
    public static void main(String[] args){

        EngineFactory.field(45,80);

        EngineFactory.object(22.5,2.5);


        CreatObject[] obj = new CreatObject[5];

        double row = 7.5;

        for(int i =0; i < 5; i++){
            obj[i] = new CreatObject(row, 75);
            obj[i].init();
            row += 7.5;
        }

        try {
            for(int i = 0; i < obj.length; i++){
                obj[i].move();
                obj[i].hide();
            }
        }catch (Exception e){
            System.out.printf("2");
        }



    }

}
