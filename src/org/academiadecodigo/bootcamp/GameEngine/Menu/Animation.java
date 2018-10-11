package org.academiadecodigo.bootcamp.GameEngine.Menu;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Animation {

    private Menu menu;
    private Picture[] pictures;

    private double maximumRadius;
    private int radius;
    private boolean isGrowing;

    public Animation() {

        this.menu = menu;
        this.maximumRadius = maximumRadius;
        this.radius = 0;
        this.isGrowing = true;

        this.pictures = new Picture[3];
        this.grow();
    }

    public void init() {

        


    }

    public void grow() {
        if (this.radius < this.maximumRadius) {

            for (Picture pic : pictures) {

                pic.grow(1, 1);
            }

            this.radius++;
        }
    }

    public void shrink() {
        if (this.radius > 0) {

            for (Picture pic : pictures) {
                pic.grow(-1, -1);
            }

            this.radius--;
        }
    }

    /*
    public void collapse() {
        this.radius = 0;
        this.isGrowing = true;
        this.ellipse.grow(-this.ellipse.getWidth(), -this.ellipse.getHeight());
        this.ellipse.delete();
    }
     */
    public void pump() {
        if (this.radius == 0) {

            this.isGrowing = true;
            this.grow();
        } else if (this.radius == this.maximumRadius) {

            this.isGrowing = false;
            this.shrink();
        } else if (this.isGrowing) {

            this.grow();
        } else {

            this.shrink();
        }
    }
}
