package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.GameEngine.Field.Canvas;
import org.academiadecodigo.bootcamp.GameEngine.Objects.CreateObject;

public class EngineFactory {

    public static void field(){
        Canvas filed = new Canvas();
        filed.init();
    }

    public static void object(double row, double col){
        CreateObject object = new CreateObject(row,col);
        object.init();
    }



}
