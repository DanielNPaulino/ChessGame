package pt.ipbeja.po2.xadrez.model;

import pt.ipbeja.po2.xadrez.gui.View;
import pt.ipbeja.po2.xadrez.model.Pieces.*;

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
    private PlayerColor PlayerColor;

    private List<Piece> blackPieces = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();

    public ChessBoard(View view) {
        this.dataBoard = new Piece[SIZE][SIZE];
        this.VIEW = view;
        this.setPieces();
    }

    private void setPieces() {
       this.setWhitePieces();
       this.setBlackPieces();

    }

    private void setWhitePieces(){
        this.dataBoard[0][0] = new Rook(this, PlayerColor.White, new Position(0, 0));
        this.dataBoard[0][1] = new Knight(this, PlayerColor.White, new Position(0, 1));
        this.dataBoard[0][2] = new Bishop(this, PlayerColor.White, new Position(0, 2));
        this.dataBoard[0][3] = new King(this, PlayerColor.White, new Position(0, 3));
        this.dataBoard[0][4] = new Queen(this, PlayerColor.White, new Position(0, 4));
        this.dataBoard[0][5] = new Bishop(this, PlayerColor.White, new Position(0, 5));
        this.dataBoard[0][6] = new Knight(this, PlayerColor.White, new Position(0, 6));
        this.dataBoard[0][7] = new Rook(this, PlayerColor.White, new Position(0, 7));
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < SIZE ; j++) {
                this.dataBoard[i][j] = new Pawn(this, PlayerColor.White, new Position(i, j));
            }
        }
        for (int i = 0; i < this.SIZE/4; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                this.whitePieces.add(dataBoard[i][j]);
            }
        }
        System.out.println(whitePieces);

    }

    private void setBlackPieces(){
        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < SIZE ; j++) {
                this.dataBoard[i][j] = new Pawn(this, PlayerColor.Black, new Position(i, j));
            }
        }
        this.dataBoard[7][0] = new Rook(this, PlayerColor.Black, new Position(7, 0));
        this.dataBoard[7][1] = new Knight(this, PlayerColor.Black, new Position(7, 1));
        this.dataBoard[7][2] = new Bishop(this, PlayerColor.Black, new Position(7, 2));
        this.dataBoard[7][3] = new King(this, PlayerColor.Black, new Position(7, 3));
        this.dataBoard[7][4] = new Queen(this, PlayerColor.Black, new Position(7, 4));
        this.dataBoard[7][5] = new Bishop(this, PlayerColor.Black, new Position(7, 5));
        this.dataBoard[7][6] = new Knight(this, PlayerColor.Black, new Position(7, 6));
        this.dataBoard[7][7] = new Rook(this, PlayerColor.Black, new Position(7, 7));

        for (int i = 6; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                this.blackPieces.add(dataBoard[i][j]);
            }
        }
        System.out.println(blackPieces);
    }

    public void placeClicked(Position position){


    }




    public Piece getPiece(int row, int col) {
        return this.dataBoard[row][col];
    }

    public int getSIZE() {
        return this.SIZE;
    }
}
