package pt.ipbeja.po2.chess.model;

import javafx.geometry.Pos;
import pt.ipbeja.po2.chess.gui.View;
import pt.ipbeja.po2.chess.model.Pieces.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class ChessBoard {

    private final View VIEW;
    private final int SIZE = 8;
    public Piece[][] dataBoard;
    private PlayerColor playerColor;
    private List<Piece> blackPieces = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private int r, c;
    private List<Position> positions;
    int counter = 0;
    private Piece myPiece;
    private boolean playerTurn=false;


    /**
     * class Contructor
     *
     * @param view
     */
    public ChessBoard(View view) {
        this.dataBoard = new Piece[SIZE][SIZE];
        this.VIEW = view;
        this.setPieces();
        positions = new ArrayList<>();
    }

    /**
     * calls the methods to set pieces
     */
    private void setPieces() {
        this.setWhitePieces();
        this.setBlackPieces();
    }

    /**
     * set the white pieces in an array of arrays
     */
    private void setWhitePieces() {
        //TESTING king->
        this.dataBoard[4][4] = new Bishop(this, playerColor.Black, new Position(4, 4));
        //<--TESTING king

        this.dataBoard[0][0] = new Rook(this, playerColor.Black, new Position(0, 0));
        this.dataBoard[0][1] = new Knight(this, playerColor.Black, new Position(0, 1));
        this.dataBoard[0][2] = new Bishop(this, playerColor.Black, new Position(0, 2));
        this.dataBoard[0][3] = new Queen(this, playerColor.Black, new Position(0, 3));
        this.dataBoard[0][4] = new King(this, playerColor.Black, new Position(0, 4));
        this.dataBoard[0][5] = new Bishop(this, playerColor.Black, new Position(0, 5));
        this.dataBoard[0][6] = new Knight(this, playerColor.Black, new Position(0, 6));
        this.dataBoard[0][7] = new Rook(this, playerColor.Black, new Position(0, 7));
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.dataBoard[i][j] = new Pawn(this, playerColor.Black, new Position(i, j));
            }
        }
        for (int i = 0; i < this.SIZE / 4; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                this.whitePieces.add(dataBoard[i][j]);
            }
        }
        // System.out.println(whitePieces);

    }

    /**
     * set the black pieces in an array of arrays
     */
    private void setBlackPieces() {
        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.dataBoard[i][j] = new Pawn(this, playerColor.White, new Position(i, j));
            }
        }
        this.dataBoard[2][2] = new Pawn(this, playerColor.White, new Position(2, 2));
        this.dataBoard[7][0] = new Rook(this, playerColor.White, new Position(7, 0));
        this.dataBoard[7][1] = new Knight(this, playerColor.White, new Position(7, 1));
        this.dataBoard[7][2] = new Bishop(this, playerColor.White, new Position(7, 2));
        this.dataBoard[7][3] = new Queen(this, playerColor.White, new Position(7, 3));
        this.dataBoard[7][4] = new King(this, playerColor.White, new Position(7, 4));
        this.dataBoard[7][5] = new Bishop(this, playerColor.White, new Position(7, 5));
        this.dataBoard[7][6] = new Knight(this, playerColor.White, new Position(7, 6));
        this.dataBoard[7][7] = new Rook(this, playerColor.White, new Position(7, 7));

        for (int i = 6; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                this.blackPieces.add(dataBoard[i][j]);
            }
        }
        // System.out.println(blackPieces);
    }

    public void clickPiece(int row, int col){
        if(getPiece(row,col) != null){
            if((playerTurn && getPiece(row,col).getColor().equals("White")) || (!playerTurn && getPiece(row,col).getColor().equals("Black"))){
                System.out.println("piece selected");
                this.myPiece = getPiece(row,col);
            }else{
                System.out.println("claro que carreguei shit");
                this.eatPiece(row,col);
            }
        }else{
            System.out.println("piece moved");
            this.movePiece(row,col);
        }
    }

    private void movePiece(int row, int col){
        Position position = myPiece.getPosition();
        Position targetPosition = new Position(row,col);
        this.saveList(position.getLine(),position.getCol());
        for (int i = 0; i < this.positions.size(); i++) {
            System.out.println(positions.get(i)+" " + targetPosition);
            if (this.positions.get(i).equals(targetPosition)) {
                System.out.println("for REAAALLLZ");
                dataBoard[position.getLine()][position.getCol()] = null;
                dataBoard[targetPosition.getLine()][targetPosition.getCol()] = myPiece;
                myPiece.setPosition(targetPosition);
                playerTurn=!playerTurn;
            }
        }
    }

    private void eatPiece(int row, int col){

    }

    private void saveList(int row, int col) {
        this.positions = getPiece(row, col).possibleMoves();
    }

    public void movePiece2(int row, int col) {
        setVar();
        saveList(row, col);
        if (counter == 1) {
            Position position = new Position(row, col);
            if (getPiece(row, col).possibleMoves().equals(this.positions)) {
                System.out.println("okkk");
                System.out.println(position.getLine()+","+position.getCol());
                for (int i = 0; i < positions.size(); i++) {
                    if (this.positions.get(i).equals(position)) {
                        System.out.println("ok");
                        dataBoard[row][col] = new Pawn(this, playerColor.White, new Position(row, col));
                    }
                }
            }
            counter =-1;
        }
        saveList(row, col);
        counter++;
    }

    public void setVar() {
        Position pos = VIEW.getPos();
        this.r = pos.getLine();
        this.c = pos.getCol();
    }

    /**
     * @param row coordinate
     * @param col coordinate
     * @return a Piece
     */
    public Piece getPiece(int row, int col) {
        return this.dataBoard[row][col];
    }

    public int getSIZE() {
        return this.SIZE;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
