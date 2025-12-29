package com.example;
import com.example.model.GameStatus;
public class Main {
    public static void main(String[] args) {
        System.out.println("====> TicTacToe game\n");
        TicTacToeGame game=new TicTacToeGame();
        game.initializeGame();
        GameStatus status=game.startGame();
        System.out.println("\n==> Game Over");
        switch(status){
            case WIN:
                System.out.println("It's WIN");
                break;
            case DRAW:
                System.out.println("It's WIN");
                break;
            default:
                System.out.println("Game Ends");
                break;
        }
    }
}