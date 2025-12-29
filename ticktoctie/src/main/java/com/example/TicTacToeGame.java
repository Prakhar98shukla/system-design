package com.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.example.model.Board;
import com.example.model.GameStatus;
import com.example.model.Pair;
import com.example.model.PieceType;
import com.example.model.Player;
import com.example.model.PlayingPiece;
import com.example.model.PlayingPieceO;
import com.example.model.PlayingPieceX;

public class TicTacToeGame {
             private Deque <Player> player;
             private Board board;
             Player winner;
             private PlayingPiece playingPiece;

     public void initializeGame(){

            player=new LinkedList<>();
            PlayingPiece o=new PlayingPieceO();
            Player player1=new Player("sss", o);
            PlayingPiece x=new PlayingPieceX();
            
            Player player2=new Player("ffff", x);
            player.add(player1);
            player.add(player2);
            System.out.println("ggggg:"+player1.getName()+":::Size"+player.size());
            board=new Board(3);

     }

     public GameStatus startGame(){
        boolean noWinner = true;
        while(noWinner){

            Player currectPlayer = player.removeFirst();
            board.printBoard();
            List<Pair<Integer,Integer>> freeCell=board.getFreeCell();

            if(freeCell.isEmpty()){
                noWinner =false;
                player.add(currectPlayer);
                continue;
            }
            System.out.println("Player:"+currectPlayer.getName()+" -Please enter[row, column]: ");

            Scanner inputScanner = new Scanner(System.in);
            String s=inputScanner.nextLine();
            String[] val=s.split(",");
            int row=Integer.valueOf(val[0]);
            int col=Integer.valueOf(val[1]);
            boolean validMove = board.addPiece(row, col, playingPiece);

            if(!validMove){
                noWinner=false;
                continue;
            }

            player.addLast(currectPlayer);

            boolean isWinner=checkForWinner(row,col,currectPlayer.getPlayingPiece().getType());
            if(isWinner){
                board.printBoard();
                winner=currectPlayer;
                return GameStatus.WIN;
            }
        }
        return GameStatus.DRAW;
     }

     public boolean checkForWinner(int row,int col,PieceType type){
        boolean rowMatch =true;
        boolean columnMatch =true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch =true;
        int len=board.size;
        for(int r=0;r<len;r++){
            if(board.board[row][r]==null||board.board[row][r].type!=type) {
                rowMatch=false;
                break;
            }
        }
        for(int r=0;r<len;r++){
            if(board.board[r][col]==null||board.board[r][col].type!=type) {
                columnMatch=false;
                break;
            }
        }

        for(int r=0, c=0;r<len;r++,c++){
            if(board.board[r][c]==null||board.board[r][c].type!=type) {
                diagonalMatch=false;
                break;
            }
        }

        for(int r=0, c=len-1;r<len;r++,c--){
            if(board.board[r][c]==null||board.board[r][c].type!=type) {
                antiDiagonalMatch=false;
                break;
            }
        }

        return rowMatch||columnMatch||diagonalMatch||antiDiagonalMatch;
     }
             
}
