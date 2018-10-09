package org.academiadecodigo.bootcamp.GameEngine.Field;


import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;

public class Position implements Grid {

    private double row;
    private double col;
    private int CELLSIZE = 40;
    private int counterMoves = 0;

    public Position(double row, double col){
        this.row = row;
        this.col = col;
    }


    public double getRow(){
        return row;
    }

    public double getCol(){
        return col;
    }

    public double getWidth(){
        return col * CELLSIZE;
    }

    public double getHeight(){
        return row * CELLSIZE;
    }

    public int getCELLSIZE() {
        return CELLSIZE;
    }

    public void setCol(double col) {
        this.col = col;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public void movePosition(int speed, Directions direction){

        counterMoves += speed;

        if(counterMoves >= CELLSIZE){

            switch (direction){
                case UP:
                    row = row - 1;
                    break;
                case DOWN:
                    row = row +1;
                    break;
                case LEFT:
                    col = col -1;
                    break;
                case RIGHT:
                    col = col + 1;
                    break;
            }

            counterMoves = 0;
        }
    }
}
