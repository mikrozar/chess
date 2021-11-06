public class Horse extends ChessPiece{

    public Horse (String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);
        if ((line==toLine)&&(column==toColumn)) {
            return false;
        } else if ((toLine>7)||(toLine<0)||(toColumn>7)||(toColumn<0)){
            return false;
        } else if (((dx == 1)&&(dy == 2)) || ((dx == 2)&&(dy == 1))) {
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