package main;

public class ChessBoard {

    private ChessField[][] chessFields;

    public ChessBoard()
    {
        initializeChessFields();
    }

    private void initializeChessFields() {
        chessFields = new ChessField[8][8];

        Color nextFieldColor = Color.WHITE;

        for(int i=0;i < this.chessFields.length; i++) {
            for(int j=0; j<this.chessFields[i].length; j++)
            {
                this.chessFields[i][j] = new ChessField(nextFieldColor,i,j);
                if (nextFieldColor == Color.WHITE)
                    nextFieldColor = Color.BLACK;
                else nextFieldColor = Color.WHITE;
            }
            if (nextFieldColor == Color.WHITE)
                nextFieldColor = Color.BLACK;
            else nextFieldColor = Color.WHITE;
        }
    }

    public void printChessFields()
    {
        if(this.chessFields != null) {
            for (int i = 0; i < this.chessFields.length; i++) {
                for (int j = 0; j < this.chessFields[i].length; j++) {
                    System.out.print(chessFields[i][j].toString() + " ");
                }
                System.out.println();
            }
        }
    }


}
