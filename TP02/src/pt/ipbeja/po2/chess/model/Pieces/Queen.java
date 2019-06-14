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
public class Queen extends Piece {

    private String colorAndType;
    private Position position;
    private PlayerColor playerColor;
    private ChessBoard gameModel;
    private String type;
    private int prevRow, prevCol;

    public Queen(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.type = "Queen";
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

        if (this.colorAndType.equals("WhiteQueen")) {

        }

        if (this.colorAndType.equals("BlackQueen")) {

        }
        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {
        List<Position> possibleTakes = new ArrayList<>();
        gameModel.setVar();
        int col = gameModel.getC();
        int row = gameModel.getR();

        if(getColor().equals("White")){

        }
        if (getColor().equals("Black")) {

        }
        return possibleTakes;
    }

    public String movementText(Position begin, Position end){
        return null;
    }
    @Override

    public String toString() {
        return this.colorAndType + this.position ;
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
