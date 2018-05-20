package com.lukasanda;


import java.util.Random;

public class TheJoker {
    public String giveMeAJoke() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                return "What do you get when you wake up on a workday and realize you ran out of " +
                        "coffee?\n" +
                        "-\n" +
                        "A depresso.";
            case 1:
                return "I used to breed rabbits. Then I realized they can handle it themselves.";
            case 2:
                return "Why are eggs not very much into jokes? Because they could crack up.\n";
            case 3:
                return "What is the difference between a snowman and a snowwoman?\n\nSnowballs!";
            default:
                return "I used to breed rabbits. Then I realized they can handle it themselves.";
        }
    }
}
