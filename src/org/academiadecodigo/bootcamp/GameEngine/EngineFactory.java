package org.academiadecodigo.bootcamp.GameEngine;

public class EngineFactory {
    public static void field(int row, int col){
        Canvas filed = new Canvas(row,col);
        filed.init();
    }

    public static void object(double row, double col){
        CreateObject object = new CreateObject(row,col);
        object.init();
    }



}
