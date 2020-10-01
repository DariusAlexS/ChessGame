package main;

public abstract class ChessPiece {

    protected ChessField currentField;
    protected final Color pieceColor;

    protected ChessPiece(Color pieceColor, ChessField startField) {
        this.currentField   = startField;
        this.pieceColor     = pieceColor;
    }

    public abstract void movePiece(ChessField destinationField);

    public abstract boolean validateMoveIsLegal(ChessField destinationField, ChessField[][] chessBoard);

    public ChessField getCurrentField() {
        return currentField;
    }

    protected void setCurrentField(ChessField currentField) {
        this.currentField = currentField;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public boolean hasOtherPieceSameColor(ChessPiece otherPiece)
    {
        if(otherPiece!= null)
            return this.pieceColor == otherPiece.getPieceColor();
        else
            throw new NullPointerException("Null value passed instead of piece");
    }

}
