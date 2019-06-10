package pt.ipbeja.po2.xadrez.model.Pieces;

;
import pt.ipbeja.po2.xadrez.model.ChessBoard;
import pt.ipbeja.po2.xadrez.model.PlayerColor;
import pt.ipbeja.po2.xadrez.model.Position;

import java.util.List;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Rook extends Piece{
    private String colorAndType;
    private Position pos;




    public Rook(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.colorAndType = playerColor + " Rook";
        this.pos = position;

    }

    @Override
    public List<Position> possibleMoves() {
        return null;
    }

    @Override
    public List<Position> possibleTakes() {
        return null;
    }

    public String movementText(Position begin, Position end){
        return null;
    }
    @Override
    public String toString() {
        return this.colorAndType + this.pos ;
    }

    @Override
    public String getColorAndType(){
        return this.colorAndType;
    }


}
