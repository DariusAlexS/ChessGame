package main;

public class King extends ChessPiece{

    private boolean hasPieceMoved;

    public King(Color pieceColor, ChessField startingField)
    {
        super(pieceColor,startingField);
        this.hasPieceMoved = false;
    }
    @Override
    public void movePiece(ChessField destinationField, ChessBoard chessBoard) {
        if (isMoveIsLegal(destinationField, chessBoard))
        {}
    }

    @Override
    public boolean isMoveIsLegal(ChessField destinationField, ChessBoard chessBoard) {
        return false;
    }

    private void lockCastlingForPiece(){
        this.hasPieceMoved = true;
    }
}
