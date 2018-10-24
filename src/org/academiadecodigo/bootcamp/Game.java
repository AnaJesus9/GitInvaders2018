package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameengine.CollisionDetector;
import org.academiadecodigo.bootcamp.gameengine.field.Direction;
import org.academiadecodigo.bootcamp.gameengine.field.Background;
import org.academiadecodigo.bootcamp.gameengine.utils.GameConfigs;
import org.academiadecodigo.bootcamp.gameengine.menu.Menu;
import org.academiadecodigo.bootcamp.gameengine.sprites.Score;
import org.academiadecodigo.bootcamp.gameobjects.*;
import org.academiadecodigo.bootcamp.gameobjects.enemies.Ship;
import org.academiadecodigo.bootcamp.music.Music;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    //TODO: resource paths all over the place should be centralized in a class with all of them as constants

    private final Player player;
    private final Ship[] enemies;
    private final Keyboard keyboard;
    private final Score score;
    private final Menu menu;

    public Game() {
        this.player = new Player();
        this.enemies = new Ship[GameConfigs.NUMBER_OF_ENEMIES];
        this.keyboard = new Keyboard(this);
        this.score = new Score();
        this.menu = new Menu();
    }

    public void init() {
        implementKeys();
        createNewWave();
        menu.init();
    }

    public void start() throws InterruptedException {
        while (menu.isMenuOn()) {
            Thread.sleep(200);
        }

        Background field = new Background();
        field.init();

        Music m = new Music("back");
        m.startMusic(true);

        while (true) {

            Thread.sleep(10);
            field.animate();
            player.animate();
            player.moveBullet();

            moveEnemies();
            CollisionDetector.checkCollisions(enemies, player);

            if (player.isDestroyed()) {

                Music dead = new Music("player_dead");
                dead.startMusic(true);

                Thread.sleep(5000);
                System.exit(0);
            }

            if (checkEndOfWave()) {
                createNewWave();
            }

        }
    }

    private void moveEnemies() {
        for (Ship enemy : enemies) {

            if (enemy.isDestroyed()) {
                continue;
            }
            enemy.move();
            enemy.moveBullet();
        }
    }

    private void createNewWave() {
        for (int i = 0; i < GameConfigs.NUMBER_OF_ENEMIES; i++) {
            this.enemies[i] = new Ship();
        }
    }

    private boolean checkEndOfWave() {
        for (Ship enemy : enemies) {
            if (!enemy.isDestroyed()) {
                return false;
            }
        }
        score.increaseScore();
        return true;
    }

    private void implementKeys() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
        this.keyboard.addEventListener(space);
    }

    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                player.move(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                player.move(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                Music m = new Music("bullet");
                m.startMusic(true);
                player.shoot();
                break;
        }

    }

    public void keyReleased(KeyboardEvent e) {

    }
}
