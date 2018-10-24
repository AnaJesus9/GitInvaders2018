package org.academiadecodigo.bootcamp.gameengine.utils;


public final class Converter {

    private Converter() {
    }

    public static int pixelToCoordinate(int pixelValue) {
        return (int) Math.round((double) pixelValue / GameConfigs.CELL_SIZE);
    }

    public static int coordinateToPixel(int coordinate) {
        return coordinate * GameConfigs.CELL_SIZE;
    }
}
