public class King extends ChessPiece {

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "K";
    }

    public King (String color) {
        super(color);
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);
        if ((line==toLine)&&(column==toColumn)) {
            return false;
        } else if ((toLine>7)||(toLine<0)||(toColumn>7)||(toColumn<0)){
            return false;
        } else if ((dx<=1)&&(dy<=1)) {
            if (chessBoard.board[toLine][toColumn] == null){
                return true;
            } else if (chessBoard.board[toLine][toColumn].getColor() == this.getColor()) {
                return false;
            } else if (chessBoard.board[toLine][toColumn].getColor() != this.getColor()) {
                return true;
            }
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if ((line>7)||(line<0)||(column>7)||(column<0)) {
            return false;
        } else {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}