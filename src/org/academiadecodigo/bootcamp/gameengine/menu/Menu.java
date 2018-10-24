package org.academiadecodigo.bootcamp.gameengine.menu;

import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Menu implements KeyboardHandler {

    private Picture menu;
    private Keyboard keyboard;
    private boolean inCredits;
    private boolean menuOn;

    public Menu() {
        this.keyboard = new Keyboard(this);
        inCredits = false;
        menuOn = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                menu.delete();
                menuOn = false;
                break;

            case KeyboardEvent.KEY_2:
                System.exit(0);
                break;

            case KeyboardEvent.KEY_3:
                if (inCredits) {
                    menu.delete();
                    showMenu();
                    inCredits = false;
                } else {
                    showCredits();
                    inCredits = true;
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void init() {

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

        KeyboardEvent creditsExitKey = new KeyboardEvent();
        creditsExitKey.setKey(KeyboardEvent.KEY_4);
        creditsExitKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(creditsExitKey);

        showMenu();

    }

    private void showMenu() {

        menu = new Picture(GameConfigs.MENU_X, GameConfigs.MENU_Y, "resources/git_invaders_logo_4.png");
        menu.draw();
    }

    private void showCredits() {
        menu.delete();
        menu = new Picture(GameConfigs.MENU_X, GameConfigs.MENU_Y, "resources/git_invaders_credits.png");
        menu.draw();
    }

    public boolean isMenuOn() {
        return menuOn;
    }
}
