public class Queen extends ChessPiece {

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "Q";
    }

    public Queen (String color) {
        super(color);
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);
        if ((line==toLine)&&(column==toColumn)) {
            return false;
        } else if ((toLine>7)||(toLine<0)||(toColumn>7)||(toColumn<0)){
            return false;
        } else if (((dx>0)&&(dy==0))||((dx==0)&&(dy>0))||(dx==dy)) {
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
}