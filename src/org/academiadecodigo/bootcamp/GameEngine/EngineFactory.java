package org.academiadecodigo.bootcamp.GameEngine;

public class EngineFactory {
    public static void field(int row, int col){
        Canvas filed = new Canvas(row,col);
        filed.init();
    }

    public static void object(double row, double col){
        CreatObject object = new CreatObject(row,col);
        object.init();
    }



}
