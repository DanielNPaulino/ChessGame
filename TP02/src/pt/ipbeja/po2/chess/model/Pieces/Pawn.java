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
public class Pawn extends Piece {

    private String colorAndType;
    private Position position;
    private PlayerColor playerColor;
    private ChessBoard chessBoard;


    public Pawn(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.colorAndType = playerColor + " Pawn";
        this.position = position;
        this.playerColor = playerColor;
        this.chessBoard = board;

    }

    public void pawnMoves(Position position) {

    }

    /**
     *
     * @return the list of possible moves for this piece
     */
    @Override
    public List<Position> possibleMoves() {

        int row = this.position.getLine();
        int col = this.position.getCol();
        List<Position> possibleMovement = new ArrayList<>();

        if (this.colorAndType.equals("White Pawn") && row == 1 ){
            Position pos = new Position(row+1,col);
            Position pos1 = new Position(row+2,col);
            possibleMovement.add(pos);
            possibleMovement.add(pos1);
        }else if(this.colorAndType.equals("White Pawn") && row != 1){
            Position pos = new Position(row+1,col);
            possibleMovement.add(pos);
        }
        if(this.colorAndType.equals("Black Pawn") && row ==6){
            Position pos = new Position(row-1,col);
            Position pos1 = new Position(row-2,col);
            possibleMovement.add(pos);
            possibleMovement.add(pos1);
        }
        else if(this.colorAndType.equals("Black Pawn") && row != 6){
            Position pos = new Position(row-1,col);
            possibleMovement.add(pos);
        }
        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {
        List<Position> possibleTakes = new ArrayList<>();
        int row = this.position.getLine();
        int col = this.position.getCol();

        if(chessBoard.canMoveTo(row-1,col) && getColor().equals("Black")) {
            String s = chessBoard.getPiece(row - 1, col).getColor();
            if (s != this.getColor() ) {
                Position pos = new Position(row - 1, col);
                possibleTakes.add(pos);
            }
        }
            if (chessBoard.canMoveTo(row + 1, col) && getColor().equals("White")) {
                String ss = chessBoard.getPiece(row + 1, col).getColor();
                if (ss != this.getColor() ) {
                    Position pos = new Position(row + 1, col);
                    possibleTakes.add(pos);
                }
            }
        return possibleTakes;
    }

    public String movementText(Position begin, Position end) {
        return null;
    }

    @Override
    public String toString() {
        return this.colorAndType + this.position;
    }

    @Override
    public String getColorAndType() {
        return this.colorAndType;
    }

    @Override
    public String getColor() {
        return playerColor+"";
    }


}
