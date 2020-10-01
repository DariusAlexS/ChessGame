package main;

import java.util.ArrayList;

public class Player {

    private final Color playerColor;

    private String playerName;
    private ArrayList<ChessPiece> playerChessPieces;

    public Player(Color playerColor, String playerName) {
        this.playerColor = playerColor;
        this.playerName = playerName;
        this.playerChessPieces = new ArrayList<ChessPiece>(16);
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void addPieceToPlayerPieces(ChessPiece piece) {
        this.playerChessPieces.add(piece);
    }


}
