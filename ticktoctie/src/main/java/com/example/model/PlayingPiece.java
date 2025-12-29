package com.example.model;

public class PlayingPiece {
             public PieceType type;

    public PlayingPiece(PieceType type) {
        this.type=type;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
             
}
