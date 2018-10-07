package org.academiadecodigo.bootcamp.GameEngine;

    public class Random {

        public static int getRandomNumber(int maxnumber){

        return (int) Math.floor((Math.random() * maxnumber) + 1);
        }

    }
