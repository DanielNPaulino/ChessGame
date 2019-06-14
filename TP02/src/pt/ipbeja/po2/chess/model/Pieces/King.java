package pt.ipbeja.po2.chess.model.Pieces;

import pt.ipbeja.po2.chess.model.ChessBoard;
import pt.ipbeja.po2.chess.model.PlayerColor;
import pt.ipbeja.po2.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class King extends Piece {

    private String colorAndType;
    private Position position;
    private PlayerColor playerColor;
    private ChessBoard gameModel;
    private String type;
    private int prevRow, prevCol;

    public King(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.type = "King";
        this.colorAndType = playerColor + this.type;
        this.position = position;
        this.playerColor = playerColor;
        this.gameModel = board;
    }

    @Override
    public List<Position> possibleMoves() {
        gameModel.setVar();
        int col = gameModel.getC();
        int row = gameModel.getR();
        List<Position> possibleMovement = new ArrayList<>();

        if (this.colorAndType.equals("WhiteKing") || this.colorAndType.equals("BlackKing")) {
            Position position = new Position(row-1,col-1);
            possibleMovement.add(position);
            Position position2 = new Position(row-1,col);
            possibleMovement.add(position2);
            Position position3 = new Position(row-1,col+1);
            possibleMovement.add(position3);
            Position position4 = new Position(row+1,col);
            possibleMovement.add(position4);
            Position position5 = new Position(row+1,col+1);
            possibleMovement.add(position5);
            Position position6 = new Position(row+1,col-1);
            possibleMovement.add(position6);
            Position position7 = new Position(row,col-1);
            possibleMovement.add(position7);
            Position position8 = new Position(row,col+1);
            possibleMovement.add(position8);
        }

        /*if (this.colorAndType.equals("BlackKing")) {

        }*/
        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {
        List<Position> possibleTakes = new ArrayList<>();
        gameModel.setVar();
        int col = gameModel.getC();
        int row = gameModel.getR();

        if(getColor().equals("White") ){
            if (this.gameModel.getPiece(row - 1, col - 1) != null) {
                String ss = this.gameModel.getPiece(row - 1, col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - 1, col ) != null) {
                String ss = this.gameModel.getPiece(row - 1, col ).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - 1, col + 1) != null) {
                String ss = this.gameModel.getPiece(row - 1, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col + 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col) != null) {
                String ss = this.gameModel.getPiece(row + 1, col ).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col );
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col + 1) != null) {
                String ss = this.gameModel.getPiece(row + 1, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col + 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col - 1) != null) {
                String ss = this.gameModel.getPiece(row + 1, col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row , col - 1) != null) {
                String ss = this.gameModel.getPiece(row , col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row, col + 1) != null) {
                String ss = this.gameModel.getPiece(row, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row, col + 1);
                    possibleTakes.add(pos);
                }
            }


        }

        if (getColor().equals("Black")) {
            if (this.gameModel.getPiece(row - 1, col - 1) != null) {
                String ss = this.gameModel.getPiece(row - 1, col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - 1, col ) != null) {
                String ss = this.gameModel.getPiece(row - 1, col ).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - 1, col + 1) != null) {
                String ss = this.gameModel.getPiece(row - 1, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - 1, col + 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col) != null) {
                String ss = this.gameModel.getPiece(row + 1, col ).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col );
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col + 1) != null) {
                String ss = this.gameModel.getPiece(row + 1, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col + 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + 1, col - 1) != null) {
                String ss = this.gameModel.getPiece(row + 1, col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + 1, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row , col - 1) != null) {
                String ss = this.gameModel.getPiece(row , col - 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row, col - 1);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row, col + 1) != null) {
                String ss = this.gameModel.getPiece(row, col + 1).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row, col + 1);
                    possibleTakes.add(pos);
                }
            }
        }
        return possibleTakes;
    }

    public String movementText(Position begin, Position end){
        return null;
    }

    @Override
    public String toString() {
        return this.colorAndType + this.position;
    }

    @Override
    public String getColorAndType(){
        return this.colorAndType;
    }

    @Override
    public String getColor() {
        return this.playerColor+"";
    }

    @Override
    public String getType() {
      return this.type;
    }


}
