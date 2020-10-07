package main;

public class ChessField {

    private final int x;
    private final int y;
    private ChessPiece occupyingChessPiece;
    private final Color color;

    public ChessField(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Color getColor() {
        return color;
    }

    public String toString() {
        return "ChessField{" +
                "x=" + x +
                ", y=" + y +
                ", occupyingChessPiece=" + occupyingChessPiece +
                ", color=" + color +
                '}';
    }



    public boolean isFieldOccupiedByPiece() {
        return this.occupyingChessPiece != null;
    }

    public boolean isFieldOccupiedByPieceOfOpposingColor(Color attackingPieceColor)
    {
        if(this.isFieldOccupiedByPiece())
            return this.occupyingChessPiece.getPieceColor() != attackingPieceColor;
        else return false;
    }

    public boolean isFieldOccupiedByPieceOfSameColor(Color otherPieceColor)
    {   if(this.isFieldOccupiedByPiece())
            return this.occupyingChessPiece.getPieceColor() == otherPieceColor;
        else return false;
    }

    public void setToOccupiedByPiece(ChessPiece occupyingPiece)
    { this.occupyingChessPiece = occupyingPiece; }

    public void setToUnoccupiedByPiece()
    { this.occupyingChessPiece = null; }

    public ChessPiece getOccupyingChessPiece()
    { return this.occupyingChessPiece;
    }
}
