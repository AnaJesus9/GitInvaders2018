package org.academiadecodigo.bootcamp.GameEngine.Menu;

import org.academiadecodigo.bootcamp.GameEngine.Field.Grid;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Game;

public class Menu implements Grid, KeyboardHandler {

    private Game game;
    private Picture menu;
    private int row;
    private int col;
    private int CELLSIZE = GameConfigs.CELLSIZE;
    private Keyboard keyboard;

    public Menu(int row, int col, Game game) {
        this.game = game;
        this.row = row;
        this.col = col;
        keyboard = new Keyboard(this);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                menu.delete();
                game.start();
                break;

            case KeyboardEvent.KEY_2:
                  System.exit(0);
                  break;

            case KeyboardEvent.KEY_3:
               menu.delete();
               credits();

                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void init() {

        mainMenu();

        KeyboardEvent enterKey = new KeyboardEvent();
        enterKey.setKey(KeyboardEvent.KEY_1);
        enterKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(enterKey);


        KeyboardEvent escapeKey = new KeyboardEvent();
        escapeKey.setKey(KeyboardEvent.KEY_2);
        escapeKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(escapeKey);

        KeyboardEvent creditsKey = new KeyboardEvent();
        creditsKey.setKey(KeyboardEvent.KEY_3);
        creditsKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(creditsKey);


    }

    private void mainMenu() {

        menu = new Picture(0, 0, "resources/git_invaders_main_menu_001.png");
        menu.draw();

    }


    private void credits() {
            menu = new Picture(0,0,"resources/git_invaders_credits.png");
            menu.draw();
    }

    public void delete() {
        menu.delete();
    }


    public double getRow() {
        return row;
    }

    public double getCol() {
        return col;
    }

    public double getWidth() {
        return col * CELLSIZE;
    }

    public double getHeight() {
        return row * CELLSIZE;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCELLSIZE() {
        return CELLSIZE;
    }

    public void setCELLSIZE(int CELLSIZE) {
        this.CELLSIZE = CELLSIZE;
    }
}
