package org.academiadecodigo.bootcamp;

public class GitInvaders {

    public static void main(String[] args){
        //TODO: better organization of resources folder
        //TODO: swap printStackTraces for sout printing exception messages

        Game game = new Game();
        try{
            game.init();
            game.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
