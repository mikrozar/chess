public class Pawn extends ChessPiece {

    public Pawn (String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dx = toLine - line;
        int dy = Math.abs(column - toColumn);

        if ((line==toLine)&&(column==toColumn)) {
            return false;
        } else if ((toLine>7)||(toLine<0)||(toColumn>7)||(toColumn<0)){
            return false;
        } else if(((this.color.equals("White"))&&(line==1)&&(dx==2)&&(dy==0))||((this.color.equals("White"))&&(line==1)&&(dx==1)&&(dy<=1))) {
            if (chessBoard.board[toLine][toColumn] == null){
                return true;
            } else if (chessBoard.board[toLine][toColumn].getColor() == this.getColor()) {
                return false;
            } else if (chessBoard.board[toLine][toColumn].getColor() != this.getColor()) {
                return true;
            }
        } else if (((this.color.equals("White"))&&(line!=1)&&(dx==1)&&(dy==0))||((this.color.equals("White"))&&(line!=1)&&(dx==1)&&(dy<=1))) {
            if (chessBoard.board[toLine][toColumn] == null){
                return true;
            } else if (chessBoard.board[toLine][toColumn].getColor() == this.getColor()) {
                return false;
            } else if (chessBoard.board[toLine][toColumn].getColor() != this.getColor()) {
                return true;
            }
        } else if(((this.color.equals("Black"))&&(line==6)&&(dx==-2)&&(dy==0))||((this.color.equals("Black"))&&(line==6)&&(dx==-1)&&(dy<=1))) {
            if (chessBoard.board[toLine][toColumn] == null){
                return true;
            } else if (chessBoard.board[toLine][toColumn].getColor() == this.getColor()) {
                return false;
            } else if (chessBoard.board[toLine][toColumn].getColor() != this.getColor()) {
                return true;
            }
        } else if (((this.color.equals("Black"))&&(line!=6)&&(dx==-1)&&(dy==0))||((this.color.equals("Black"))&&(line!=6)&&(dx==-1)&&(dy<=1))) {
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