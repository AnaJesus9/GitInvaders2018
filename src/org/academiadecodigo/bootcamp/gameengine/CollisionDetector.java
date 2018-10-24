package org.academiadecodigo.bootcamp.gameengine;

import org.academiadecodigo.bootcamp.gameobjects.Bullet;
import org.academiadecodigo.bootcamp.gameobjects.enemies.Ship;
import org.academiadecodigo.bootcamp.gameobjects.Player;

public class CollisionDetector {

    public static void checkCollisions(Ship[] enemies, Player player) {

        for (Ship enemy : enemies) {

            if (enemy.isDestroyed()) {
                continue;
            }
            if (enemy.getSprite().getPosition().getCol() == 0) {
                enemy.hit();
                player.hit();
            }

            for (Bullet bullet : player.getBullets()) {
                if (bullet != null) {
                    if (bullet.isDestroyed()) {
                        continue;
                    }

                    if (compareEnemy(enemy, bullet)) {
                        enemy.hit();
                        bullet.hit();
                    }
                }
            }
        }

        for (Ship enemy : enemies) {
            if (enemy.isDestroyed()) {
                continue;
            }

            for (Bullet bullet : enemy.getBullets()) {
                if (bullet != null) {
                    if (bullet.isDestroyed()) {
                        continue;
                    }

                    if (comparePlayer(player, bullet)) {
                        player.hit();
                        bullet.hit();
                    }
                }
            }
        }
    }

    private static boolean compareEnemy(Ship enemy, Bullet bullet) {
        return (enemy.getSprite().getPosition().getCol() == bullet.getSprite().getPosition().getCol() &&
                enemy.getSprite().getPosition().getRow() == bullet.getSprite().getPosition().getRow());
    }

    private static boolean comparePlayer(Player player, Bullet bullet) {
        return (player.getSprite().getPosition().getCol() == bullet.getSprite().getPosition().getCol() &&
                player.getSprite().getPosition().getRow() == bullet.getSprite().getPosition().getRow());
    }
}
