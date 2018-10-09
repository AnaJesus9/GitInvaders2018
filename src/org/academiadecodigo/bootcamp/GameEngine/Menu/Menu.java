package org.academiadecodigo.bootcamp.GameEngine.Menu;

import org.academiadecodigo.bootcamp.GameEngine.Field.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Menu implements Grid {

    public int row;
    public int col;
    public int CELLSIZE = 40;
    private Text menu;

    public Menu(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void init(){
        menu = new Text(6.5*40,6.5*40, "teste0");
        menu.setColor(Color.WHITE);
        menu.draw();
        menu.grow(120,60);
    }

    public void delete(){
        menu.delete();
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

}
