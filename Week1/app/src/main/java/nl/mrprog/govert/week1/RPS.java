package nl.mrprog.govert.week1;

import java.util.Random;
/**
 * Created by govert on 4/3/15.
 */
public class RPS {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSOR = 3;
    public static final int DRAW = 0;
    public static final int AI = 1;
    public static final int PLAYER = 2;


    public static int generateOuputAI() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public static int getWinner(int playerChoice, int AIChoice) {
        switch(playerChoice) {
            case ROCK:
                if (AIChoice == ROCK)
                    return DRAW;
                else if (AIChoice == PAPER)
                    return AI;
                else
                    return PLAYER;
                break;
            case PAPER:
                if (AIChoice == ROCK)
                    return PLAYER;
                else if (AIChoice == PAPER)
                    return DRAW;
                else
                    return AI;
                break;
            case SCISSOR:
                if (AIChoice == ROCK)
                    return AI;
                else if (AIChoice == PAPER)
                    return PLAYER;
                else
                    return DRAW;
                break;
        }
    }
}
