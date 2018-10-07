package org.academiadecodigo.bootcamp.GameEngine;

public class EngineFactory {
    public static void field(int row, int col){
        Canvas filed = new Canvas(row,col);
        filed.init();
    }

    public static void object(int row, int col){
        GeneratePosition object = new GeneratePosition(row,col);
        object.init();
    }



}
