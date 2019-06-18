package pt.ipbeja.po2.chess.model.Pieces;


import javafx.geometry.Pos;
import pt.ipbeja.po2.chess.model.ChessBoard;
import pt.ipbeja.po2.chess.model.PlayerColor;
import pt.ipbeja.po2.chess.model.Position;
import sun.net.www.http.PosterOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Pawn extends Piece {

    private String colorAndType;
    private PlayerColor playerColor;
    private ChessBoard gameModel;
    private String type;
    private int prevRow, prevCol;


    public Pawn(ChessBoard board, PlayerColor playerColor, Position position) {
        super(board, playerColor, position);
        this.type = "Pawn";
        this.colorAndType = playerColor + this.type;
        this.playerColor = playerColor;
        this.gameModel = board;
    }


    /**
     * @return the list of possible moves for this piece
     */
    @Override
    public List<Position> possibleMoves() {

        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();
        List<Position> possibleMovement = new ArrayList<>();

        if (this.colorAndType.equals("BlackPawn") && row == 1) {
            if (gameModel.isInside(row + 1, col) && gameModel.isInside(row + 2, col)) {
                Position pos = new Position(row + 1, col);
                Position pos1 = new Position(row + 2, col);
                possibleMovement.add(pos);
                possibleMovement.add(pos1);
            }
        }
        if (this.colorAndType.equals("BlackPawn") && row != 1) {
            if (gameModel.isInside(row + 1, col)) {
                Position pos = new Position(row + 1, col);
                possibleMovement.add(pos);
            }
        }
        if (this.colorAndType.equals("WhitePawn") && row == 6) {
            if (gameModel.isInside(row - 1, col) && gameModel.isInside(row - 2, col)) {
                Position pos = new Position(row - 1, col);
                Position pos1 = new Position(row - 2, col);
                possibleMovement.add(pos);
                possibleMovement.add(pos1);
            }
        }
        if (this.colorAndType.equals("WhitePawn") && row != 6) {
            if (gameModel.isInside(row - 1, col)) {
                Position pos = new Position(row - 1, col);
                possibleMovement.add(pos);
            }
        }
        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {
        List<Position> possibleTakes = new ArrayList<>();

        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();

        if (getColor().equals("White")) {
            if (gameModel.isInside(row - 1, col - 1)) {
                if (this.gameModel.getPiece(row - 1, col - 1) != null) {
                    if (!this.getColor().equals(this.gameModel.getPiece(row - 1, col - 1).getColor())) {
                        Position pos = new Position(row - 1, col - 1);
                        possibleTakes.add(pos);
                    }
                }
            }
            if (gameModel.isInside(row - 1, col + 1)) {
                if (this.gameModel.getPiece(row - 1, col + 1) != null) {
                    if (!this.getColor().equals(this.gameModel.getPiece(row - 1, col + 1).getColor())) {
                        Position pos = new Position(row - 1, col + 1);
                        possibleTakes.add(pos);
                    }
                }
            }
        }
        if (getColor().equals("Black")) {
            if (gameModel.isInside(row + 1, col - 1)) {
                if (this.gameModel.getPiece(row + 1, col - 1) != null) {

                    if (this.getColor().equals(this.gameModel.getPiece(row + 1, col - 1).getColor())) {
                        Position pos = new Position(row + 1, col - 1);
                        possibleTakes.add(pos);
                    }
                }
            }
            if (gameModel.isInside(row + 1, col + 1)) {
                if (this.gameModel.getPiece(row + 1, col + 1) != null) {

                    if (!this.getColor().equals(this.gameModel.getPiece(row + 1, col + 1).getColor())) {
                        Position pos = new Position(row + 1, col + 1);
                        possibleTakes.add(pos);
                    }
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
        return this.colorAndType + this.getPosition();
    }

    @Override
    public String getColorAndType() {
        return this.colorAndType;
    }

    @Override
    public String getColor() {
        return playerColor + "";
    }

    @Override
    public String getType() {
        return this.type;
    }

}
