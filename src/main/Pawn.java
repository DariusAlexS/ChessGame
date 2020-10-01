package main;

public class Pawn extends ChessPiece{

    // protected ChessField currentField;
    // protected final Color pieceColor;
    private boolean hasPawnMadeFirstMove;

    public Pawn(Color pieceColor, ChessField startField) {
        super(pieceColor, startField);
        this.hasPawnMadeFirstMove = false;
    }

    @Override
    public void movePiece(ChessField destinationField) {
        // How to know when which direction the pawn should move, i.e. where's the opposite king located?
        // How to know when a pawn has moved next to this pawn 2 fields in the past move?

    }

    @Override
    public boolean validateMoveIsLegal(ChessField destinationField, ChessField[][] chessBoard) {
        return false;
    }

    public boolean canPieceReachDestination(ChessField destinationField, ChessField[][] chessBoard) {

        int currX, currY, destX, destY;
        ChessPiece pieceOnDestField;

        currX = this.currentField.getX();
        currY = this.currentField.getY();
        destX = destinationField.getX();
        destY = destinationField.getY();

        pieceOnDestField = destinationField.getOccupyingChessPiece();

        // check if other piece has same color
        if (hasOtherPieceSameColor(pieceOnDestField))
            return false;

        if(this.pieceColor == Color.WHITE)
            // movement by 1 field forward
            if (destY - currY == 1 && currX == destX) {
                return !destinationField.isFieldOccupiedByPiece();
            }
            // movement by 2 fields forward
            else if (!hasPawnMadeFirstMove() && destY - currY == 2 && currX == destX){
                return !destinationField.isFieldOccupiedByPiece();
            }
            // diagonal attack
            else { // if(this.pieceColor == Color.WHITE)

        }
            // check if movement 1 field ahead is eligible (need information on which direction we're allowed to move to)

            // check if movement 2 fields ahead is eligible
    }

    private boolean hasPawnMadeFirstMove()
    { return this.hasPawnMadeFirstMove; }
    private void setPawnMadeFirstMove()
    { this.hasPawnMadeFirstMove = true; }
        
    private boolean isFieldInFrontOccupied(ChessField destinationField){

        }
    }
}



