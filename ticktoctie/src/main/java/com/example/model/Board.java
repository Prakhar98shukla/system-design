package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
        public int size;
        public PlayingPiece[][] board;

    public Board(int size) {
        this.size=size;
        board=new PlayingPiece[size][size];
    }

    public boolean addPiece(int row,int col,PlayingPiece piece){
        if(board[row][col]==null){
            board[row][col]=piece;
            return true;
        }
        return false;
    }

    public List<Pair<Integer,Integer>> getFreeCell(){
        List<Pair<Integer,Integer>> cell= new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair<Integer,Integer> newPair=new Pair<>(i,j);
                    cell.add(newPair);
                }
            }
        }
        return cell;

    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].getType()+" ");
                }
                else{
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }


        
}
