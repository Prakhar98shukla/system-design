package com.example.model;

public class Player {
      public String name;
      public PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        name=this.name;
        piece=this.piece;
        System.out.print("Nme-->"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return piece;
    }

    public void setPlayingPiece(PlayingPiece piece) {
        this.piece = piece;
    }
}
