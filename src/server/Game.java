package server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board = new Board();
    private String white;
    private String black;
    private int turn;

    public Game() {
        turn = 0;
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

    public int isTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
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

    public boolean move(int fromX, int toX, int fromY, int toY){
        return board.isValid(fromX, toX, fromY, toY);
    }
}

class Board {
    List<Piece> pieces = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(0, i));
            pieces.add(new Pawn(7, i));
        }

        pieces.add(new Rook(0, 0));
        pieces.add(new Rook(0, 7));
        pieces.add(new Rook(7, 0));
        pieces.add(new Rook(7, 7));

        pieces.add(new Knight(0, 1));
        pieces.add(new Knight(0, 6));
        pieces.add(new Knight(7, 1));
        pieces.add(new Knight(7, 6));

        pieces.add(new Bishop(0, 2));
        pieces.add(new Bishop(0, 5));
        pieces.add(new Bishop(7, 2));
        pieces.add(new Bishop(7, 5));

        pieces.add(new Queen(0, 3));
        pieces.add(new Queen(7, 3));

        pieces.add(new King(0, 4));
        pieces.add(new King(7, 4));
    }

    public boolean isValid(int fromX, int toX, int fromY, int toY){
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getX() == fromX && pieces.get(i).getY() == fromY) {
                boolean ok = pieces.get(i).isValid(fromX, toX, fromY, toY);

                if(ok){
                    pieces.get(i).setX(toX);
                    pieces.get(i).setY(toY);
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

    public Piece(int x, int y) {
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
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false;
        return true;
    }

}

class King extends Piece{

    public King(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
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

    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(super.isValid(fromX, fromY, toX, toY) == false)
            return false;

        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
            return false;
        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
            return false;

        return true;
    }

}

class Bishop extends Piece{

    public Bishop(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(super.isValid(fromX, fromY, toX, toY) == false)
            return false;

        if(toX - fromX == toY - fromY)
            return true;

        return false;
    }
}

class Rook extends Piece{

    public Rook(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }


    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        if(toX == fromX)
            return true;
        if(toY == fromY)
            return true;
        return false;
    }
}

class Queen extends Piece{

    public Queen(int x, int y) {
        super(x, y);
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
        if(toY == fromY)
            return true;

        return false;
    }
}

class Pawn extends Piece{
    public Pawn(int x, int y){
        super(x, y);
    }

    @Override
    public boolean isValid(int fromX, int fromY, int toX, int toY){
        if(!super.isValid(fromX, fromY, toX, toY))
            return false;
        if(Math.abs(fromY - toY) > 1)
            return false;
        if(Math.abs(fromX - toX) > 2)
            return false;

        return true;
    }
}

