package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.GameEngine.Field.Canvas;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public class EngineFactory {

    public static void field(){
        Canvas filed = new Canvas();
        filed.init();
    }

    public static void object(double row, double col, Resource resource){
        Graphics object = new Graphics(row,col, resource);
        object.init();
    }



}
