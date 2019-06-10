package pt.ipbeja.po2.xadrez.model.Pieces;

import javafx.geometry.Pos;
import pt.ipbeja.po2.xadrez.model.ChessBoard;
import pt.ipbeja.po2.xadrez.model.PlayerColor;
import pt.ipbeja.po2.xadrez.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Pawn extends Piece {

    private String colorAndType;
    private Position position;



    public Pawn(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.colorAndType = playerColor + " Pawn";
        this.position = position;

    }

    public void pawnMoves(Position position) {

    }

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
        return null;
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


}
