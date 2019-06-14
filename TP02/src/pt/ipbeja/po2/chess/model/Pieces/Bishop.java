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
public class Bishop extends Piece {

    private String colorAndType;
    private Position position;
    private PlayerColor playerColor;
    private ChessBoard gameModel;
    private String type;
    private int prevRow, prevCol;

    public Bishop(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.type = "Bishop";
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

        if (this.type.equals("Bishop")) {

            while (gameModel.dataBoard[row][col] == null) {
                Position position = new Position(row, col);
                possibleMovement.add(position);
                //gameModel.dataBoard[row + 1][col + 1];
                //row + 1;
                //col + 1;
            }

            for (int i = 0; i < 8; i++) {
                Position position2 = new Position(row - i, col - i);
                possibleMovement.add(position2);
            }
            for (int i = 0; i < 8; i++) {
                Position position3 = new Position(row - i, col + i);
                possibleMovement.add(position3);
            }
            for (int i = 0; i < 8; i++) {
                Position position4 = new Position(row + i, col - i);
                possibleMovement.add(position4);
            }
        }
        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {

        List<Position> possibleTakes = new ArrayList<>();
        gameModel.setVar();
        int col = gameModel.getC();
        int row = gameModel.getR();

        int bishopRow = 0;
        int bishopCol = 0;

        for (int i = 0; i < 8; i++) {
            bishopCol = i;
            bishopRow = i;
        }

        if (getColor().equals("White")) {
            if (this.gameModel.getPiece(row + bishopRow, col + bishopCol) != null) {
                String ss = this.gameModel.getPiece(row + bishopRow, col + bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + bishopRow, col + bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - bishopRow, col - bishopCol) != null) {
                String ss = this.gameModel.getPiece(row - bishopRow, col - bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - bishopRow, col - bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - bishopRow, col + bishopCol) != null) {
                String ss = this.gameModel.getPiece(row - bishopRow, col + bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - bishopRow, col + bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + bishopRow, col - bishopCol) != null) {
                String ss = this.gameModel.getPiece(row + bishopRow, col - bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + bishopRow, col - bishopCol);
                    possibleTakes.add(pos);
                }
            }
        }
        if (getColor().equals("Black")) {
            if (this.gameModel.getPiece(row + bishopRow, col + bishopCol) != null) {
                String ss = this.gameModel.getPiece(row + bishopRow, col + bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + bishopRow, col + bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - bishopRow, col - bishopCol) != null) {
                String ss = this.gameModel.getPiece(row - bishopRow, col - bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - bishopRow, col - bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row - bishopRow, col + bishopCol) != null) {
                String ss = this.gameModel.getPiece(row - bishopRow, col + bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row - bishopRow, col + bishopCol);
                    possibleTakes.add(pos);
                }
            }
            if (this.gameModel.getPiece(row + bishopRow, col - bishopCol) != null) {
                String ss = this.gameModel.getPiece(row + bishopRow, col - bishopCol).getColor();
                if (ss != this.getColor()) {
                    Position pos = new Position(row + bishopRow, col - bishopCol);
                    possibleTakes.add(pos);
                }
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
        return this.playerColor + "";
    }

    @Override
    public String getType() {
        return this.type;
    }

}
