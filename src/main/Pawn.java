package main;

public class Pawn extends ChessPiece{

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

    }
    /*
    @Override
    public void movePiece(ChessField destinationField) {
        // How to know when which direction the pawn should move, i.e. where's the opposite king located?
        // How to know when a pawn has moved next to this pawn 2 fields in the past move?

    }
*/
    @Override
    public boolean isMoveIsLegal(ChessField destinationField, ChessBoard chessBoard) {
        return false;
    }

    public boolean canPieceReachDestination(ChessField destinationField, ChessBoard chessBoard) {

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
        // TODO - refactor logic to multiply the distance by 1/-1 depending on the piece color
        if (this.pieceColor == Color.WHITE)
        {
            // movement by 1 field forward
            if (destY - currY == 1 && currX == destX) {
                return !destinationField.isFieldOccupiedByPiece();
            }
            // movement by 2 fields forward
            else if (!hasPawnMadeFirstMove() && destY - currY == 2 && currX == destX) {
                // TODO - check if the field 1 distance away is empty as well

                return !destinationField.isFieldOccupiedByPiece();
            }
            // diagonal attack
            else {

            }
        }
        else // if (this.pieceColor == Color.BLACK)
        {

        }
        // check if movement 1 field ahead is eligible (need information on which direction we're allowed to move to)

        // check if movement 2 fields ahead is eligible
    }

    private boolean canPieceMoveForwardByOne(ChessBoard chessBoard)
    {

        int destYFieldCoordinate = this.currentField.getY() + 1 * this.directionalModifier;
        ChessField fieldInFrontOfPawn = chessBoard.getChessField(this.currentField.getX(),destYFieldCoordinate);

        return !fieldInFrontOfPawn.isFieldOccupiedByPiece();
    }

    private boolean canPieceMoveForwardByTwo(ChessBoard chessBoard)
    {
        int dirModifier = calculateDirectionalModifierBasedOnPieceColor();
        int destYFieldCoordinate = this.currentField.getY() + 2 * dirModifier;
        ChessField destField = chessBoard.getChessField(this.currentField.getX(),destYFieldCoordinate);

        if (this.hasPawnMadeFirstMove() && canPieceMoveForwardByOne(chessBoard) && !destField.isFieldOccupiedByPiece())
            return true;
        else return false;
    }
    private boolean isDestinationFieldDiagonalToPiece(ChessField destField)
    {
        return (Math.abs(this.currentField.getX() - destField.getX()) == 1 &&
        this.currentField.getY() + this.directionalModifier == destField.getY());
    }

    private boolean canPieceAttackDiagonalField(ChessBoard chessBoard, ChessField destDiagonalField)
    {
        return isDestinationFieldDiagonalToPiece(destDiagonalField) &&
                destDiagonalField.
    }

    private int calculateDirectionalModifierBasedOnPieceColor()
    { return this.pieceColor == Color.BLACK ? 1 : -1; }

    private boolean hasPawnMadeFirstMove()
    { return this.hasPawnMadeFirstMove; }

    private void setPawnMadeFirstMove()
    { this.hasPawnMadeFirstMove = true; }

}




