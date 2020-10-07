package main;

public class Pawn extends ChessPiece{

    private enum PawnMovementType
    {
        ONEFORWARD, TWOFORWARD, DIAGONALATTACK, ILLEGAL
    }
    // protected ChessField currentField;
    // protected final Color pieceColor;
    private boolean hasPawnMadeFirstMove;
    private int directionalModifier;

    public Pawn(Color pieceColor, ChessField startField) {
        super(pieceColor, startField);
        this.hasPawnMadeFirstMove = false;

        if(pieceColor == Color.BLACK)
            this.directionalModifier = 1;
        else this.directionalModifier = -1;
    }

    @Override
    public void movePiece(ChessField destinationField, ChessBoard chessBoard) {
        if (isMoveIsLegal(destinationField, chessBoard))
        {} // @Question - what should the capturing other pieces logic look like

            // notify the gameStateManager if a piece was captured.
            /* If an opposing piece was standing on the field,
               to which a given piece moved, the opposing piece is captured:
               It is removed from the players collection of Pieces and added to the collection
               of the captured pieces of the opposing player  (between Player & pieces?)
               Observer pattern?
               GameStateManager ?
               

             */
    }


    @Override
    public boolean isMoveIsLegal(ChessField destinationField, ChessBoard chessBoard) {
        if(this.canPawnReachDestination(destinationField, chessBoard))
            // TODO - figure out logic how to check if after a move the king won't be checked
            return true;
    }

    public boolean canPawnReachDestination(ChessField destinationField, ChessBoard chessBoard) {

        ChessPiece pieceOnDestField = destinationField.getOccupyingChessPiece();
        PawnMovementType movementType = this.calculateMovementTypeForPawn(destinationField, chessBoard);

        // check if other piece has same color
        if (hasOtherPieceSameColor(pieceOnDestField))
            return false;
        switch (movementType) {
            case ILLEGAL:
                return false;
            break;
            case ONEFORWARD:
                return canPawnMoveForwardByOne(chessBoard);
            break;
            case TWOFORWARD:
                return canPawnMoveForwardByTwo(chessBoard);
            break;
            case DIAGONALATTACK:
                return canPawnAttackDiagonalField(destinationField);
            break;
        }
    }

    private PawnMovementType calculateMovementTypeForPawn(ChessField destinationField, ChessBoard chessBoard)
    {
        int currX, currY, destX, destY;

        currX = this.currentField.getX();
        currY = this.currentField.getY();
        destX = destinationField.getX();
        destY = destinationField.getY();

        if (destY - currY == 1 * this.directionalModifier  && currX == destX)
            return PawnMovementType.ONEFORWARD;

        else if (destY - currY == 2 * this.directionalModifier && currX == destX)
            return PawnMovementType.TWOFORWARD;

        else if ( (Math.abs(currX - destX) == 1) &&
                (currY + this.directionalModifier == destY) )
            return PawnMovementType.DIAGONALATTACK;

        else return PawnMovementType.ILLEGAL;

    }

    private boolean canPawnMoveForwardByOne(ChessBoard chessBoard)
    {

        int destYFieldCoordinate = this.currentField.getY() + 1 * this.directionalModifier;
        ChessField fieldInFrontOfPawn = chessBoard.getChessField(this.currentField.getX(),destYFieldCoordinate);

        return !fieldInFrontOfPawn.isFieldOccupiedByPiece();
    }

    private boolean canPawnMoveForwardByTwo(ChessBoard chessBoard)
    {
        int destYFieldCoordinate = this.currentField.getY() + 2 *  this.directionalModifier;
        ChessField destField = chessBoard.getChessField(this.currentField.getX(),destYFieldCoordinate);

        if (!this.hasPawnMadeFirstMove() && canPawnMoveForwardByOne(chessBoard) && !destField.isFieldOccupiedByPiece())
            return true;
        else return false;
    }

    private boolean canPawnAttackDiagonalField(ChessField destDiagonalField)
    {
       return destDiagonalField.isFieldOccupiedByPieceOfOpposingColor(this.pieceColor);
    }

    private int calculateDirectionalModifierBasedOnPieceColor()
    { return this.pieceColor == Color.BLACK ? 1 : -1; }

    private boolean hasPawnMadeFirstMove()
    { return this.hasPawnMadeFirstMove; }

    private void setPawnMadeFirstMove()
    { this.hasPawnMadeFirstMove = true; }

}




