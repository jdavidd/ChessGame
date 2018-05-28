package server;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board = new Board();
    private String white;
    private String black;

    public Game() {
    }
    public Game(String white, String black){
        this.white = white;
        this.black = black;
        
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    public boolean move(int fromX, int fromY, int toX, int toY){
        return board.isValid(fromX, fromY, toX, toY);
    }
}
   
class Board {
    List<Piece> pieces = new ArrayList<>();
        private int turn;
    public Board() {
        turn = 0;
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(1, i, "white"));
            pieces.add(new Pawn(6, i, "black"));
        }

        pieces.add(new Rook(0, 0, "white"));
        pieces.add(new Rook(0, 7, "white"));
        pieces.add(new Rook(7, 0, "black"));
        pieces.add(new Rook(7, 7, "black"));

        pieces.add(new Knight(0, 1, "white"));
        pieces.add(new Knight(0, 6, "white"));
        pieces.add(new Knight(7, 1, "black"));
        pieces.add(new Knight(7, 6, "black"));

        pieces.add(new Bishop(0, 2,"white"));
        pieces.add(new Bishop(0, 5,"white"));
        pieces.add(new Bishop(7, 2,"black"));
        pieces.add(new Bishop(7, 5,"black"));

        pieces.add(new Queen(0, 3, "white"));
        pieces.add(new Queen(7, 3, "black"));

        pieces.add(new King(0, 4, "white"));
        pieces.add(new King(7, 4, "black"));
    }

    
    public  int getTurn() {
        return this.turn;
    }

    public  void setTurn(int turn) {
        this.turn = turn;
    }
    public boolean isValid(int fromX, int fromY, int toX, int toY){
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getX() == fromX && pieces.get(i).getY() == fromY) {
                boolean ok = pieces.get(i).isValid(fromX, fromY, toX, toY);
                String owner;
                if(this.getTurn() == 0)
                    owner = "white";
                else
                    owner = "black";
                ok = ok && pieces.get(i).getOwner().equals(owner);

                if(ok){
                    for(int j = 0; j < pieces.size(); j++)
                        if(pieces.get(j).getX() == toX && pieces.get(j).getY() == toY){
                            pieces.remove(j);
                            break;
                    }
                    pieces.get(i).setX(toX);
                    pieces.get(i).setY(toY);
                    this.setTurn(this.getTurn() ^ 1);
                }
                return ok;
            }
        }
        return false;
    }
}

class Piece {
    private int x;
    private int y;
    private String owner;

    Piece(int x, int y, String owner) {
        this.owner = owner;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isValid(int fromX, int fromY, int toX, int toY){
        if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        return (toX >= 0 && toX <= 7 && fromX >= 0 && fromX <= 7 && toY >= 0 && toY <= 7 && fromY >= 0 && fromY <= 7);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

class King extends Piece{

    King(int x, int y, String owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        if(Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) != Math.sqrt(2)){
            return false;
        }
        return false;
    }
}

class Knight extends Piece{

    Knight(int x, int y, String owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;

        if(Math.abs(fromX - toX) == 2 && Math.abs(fromY - toY) == 1)
            return true;
        return (Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 2);
    }

}

class Bishop extends Piece{

    Bishop(int x, int y, String owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isValid(int fromX,int fromY,  int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;

        return Math.abs(toX - fromX) == Math.abs(toY - fromY);
    }
}

class Rook extends Piece{

    Rook(int x, int y, String owner) {
        super(x, y, owner);
    }


    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        if(toX == fromX)
            return true;
        return (toY == fromY);
    }
}

class Queen extends Piece{

    Queen(int x, int y, String owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        //diagonal
        if(toX - fromX == toY - fromY)
            return true;
        if(toX == fromX)
            return true;
        return toY == fromY;

    }
}

class Pawn extends Piece{
    Pawn(int x, int y, String owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY){
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        if(Math.abs(fromY - toY) > 1)
            return false;
        return (Math.abs(fromX - toX) <= 2);
    }
}