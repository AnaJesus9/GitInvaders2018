package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.GameObjects.*;

public class Game {
    private Player player;
    private GameObjects[] gameObjects;
    private final int NUMBER_OF_ENEMIES = 20;

    public Game(){
        init();

        startGame();
    }

    public void init(){
        this.player = new Player();
        this.gameObjects = new GameObjects[NUMBER_OF_ENEMIES];
        createGameObjects();
    }

    public void startGame(){

    }

    public void createGameObjects() {
        for(int i = 0; i < NUMBER_OF_ENEMIES; i++){
            this.gameObjects[i] = ObjectFactory.createNewEnemy();
        }
    }
}
