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
        List<Position> possibleMovement = new ArrayList<>();
        possibleMovement.addAll(goDiag());
        possibleMovement.addAll(goHorVer());

        return possibleMovement;
    }

    @Override
    public List<Position> possibleTakes() {
        List<Position> possibleTakes = new ArrayList<>();
        possibleTakes.addAll(goDiagTakes());
        possibleTakes.addAll(goHorVerTakes());

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

    private List<Position> goDiag() {

        List<Position> possibleMovement = new ArrayList<>();
        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();
        int i = row + 1;
        int j = col + 1;

        while (i < gameModel.getSIZE() && j < gameModel.getSIZE() && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                Position position = new Position(i, j);
                possibleMovement.add(position);

                i++;
                j++;
            }
        }
        i = row - 1;
        j = col - 1;

        while (i >= 0 && j >= 0 && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                Position position = new Position(i, j);
                possibleMovement.add(position);

                i--;
                j--;
            }
        }
        i = row + 1;
        j = col - 1;
        while (i < gameModel.getSIZE() && j >= 0 && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                Position position = new Position(i, j);
                possibleMovement.add(position);

                i++;
                j--;
            }
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < gameModel.getSIZE() && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                Position position = new Position(i, j);
                possibleMovement.add(position);

                i--;
                j++;
            }
        }
        return possibleMovement;
    }



    private List<Position> goHorVer() {
        List<Position> possibleMovement = new ArrayList<>();
        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();
        int i = row + 1;
        int j = col + 1;

        while (i < gameModel.getSIZE() && gameModel.getPiece(i, col) == null) {
            if (gameModel.isInside(i, col)) {
                Position position = new Position(i, col);
                possibleMovement.add(position);

                i++;
            }
        }
        i = row - 1;

        while (i >= 0 && gameModel.getPiece(i, col) == null) {
            if (gameModel.isInside(i, col)) {
                Position position = new Position(i, col);
                possibleMovement.add(position);

                i--;
            }
        }

        while (j < gameModel.getSIZE() && gameModel.getPiece(row, j) == null) {
            if (gameModel.isInside(row, j)) {
                Position position = new Position(row, j);
                possibleMovement.add(position);

                j++;
            }
        }

        j = col - 1;
        while (j >= 0 && gameModel.getPiece(row, j) == null) {
            if (gameModel.isInside(row, j)) {
                Position position = new Position(row, j);
                possibleMovement.add(position);

                j--;
            }
        }

        return possibleMovement;
    }

    private List<Position> goDiagTakes() {

        List<Position> possibleTakes = new ArrayList<>();
        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();

        int i = row + 1;
        int j = col + 1;

        while (i < gameModel.getSIZE() && j < gameModel.getSIZE() && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                i++;
                j++;
            }
        }
        if (gameModel.isInside(i, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, j).getColor()) && gameModel.getPiece(i, j) != null)) {
                {
                    Position position = new Position(i, j);
                    possibleTakes.add(position);
                }
            }
        }
        i = row - 1;
        j = col - 1;

        while (i >= 0 && j >= 0 && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                i--;
                j--;
            }
        }
        if (gameModel.isInside(i, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, j).getColor()) && gameModel.getPiece(i, j) != null)) {
                {
                    Position position = new Position(i, j);
                    possibleTakes.add(position);
                }
            }
        }

        i = row + 1;
        j = col - 1;

        while (i < gameModel.getSIZE() && j >= 0 && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                i++;
                j--;
            }
        }
        if (gameModel.isInside(i, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, j).getColor()) && gameModel.getPiece(i, j) != null)) {
                {
                    Position position = new Position(i, j);
                    possibleTakes.add(position);
                }
            }
        }
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < gameModel.getSIZE() && gameModel.getPiece(i, j) == null) {
            if (gameModel.isInside(i, j)) {
                i--;
                j++;
            }
        }
        if (gameModel.isInside(i, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, j).getColor()) && gameModel.getPiece(i, j) != null)) {
                {
                    Position position = new Position(i, j);
                    possibleTakes.add(position);
                }
            }
        }

        return possibleTakes;
    }

    private List<Position> goHorVerTakes(){

        List<Position> possibleTakes = new ArrayList<>();
        int col = this.getPosition().getCol();
        int row = this.getPosition().getLine();
        int i = row + 1;
        int j = col + 1;

        while (i < gameModel.getSIZE() && gameModel.getPiece(i, col) == null) {
            if (gameModel.isInside(i, col)) {
                i++;
            }
        }
        if (gameModel.isInside(i, col)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, col).getColor()) && gameModel.getPiece(i, col) != null)) {
                {
                    Position position = new Position(i, col);
                    possibleTakes.add(position);
                }
            }
        }
        i = row - 1;

        while (i >= 0 && gameModel.getPiece(i, col) == null) {
            if (gameModel.isInside(i, col)) {
                i--;
            }
        }
        if(this.gameModel.isInside(i,col)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(i, col).getColor())) && gameModel.getPiece(i, col) != null) {
                Position position = new Position(i, col);
                possibleTakes.add(position);
            }
        }

        while (j < gameModel.getSIZE() && gameModel.getPiece(row, j) == null) {
            if (gameModel.isInside(row, j)) {
                j++;
            }
        }
        if (this.gameModel.isInside(row, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(row, j).getColor())) && this.gameModel.getPiece(row, j) != null) {
                Position position = new Position(row, j);
                possibleTakes.add(position);
            }
        }
        j = col - 1;

        while (j >= 0 && this.gameModel.getPiece(row, j) == null) {
            if (this.gameModel.isInside(row, j)) {
                j--;
            }
        }
        if (this.gameModel.isInside(row, j)) {
            if (!(this.getColor().equals(this.gameModel.getPiece(row, j).getColor())) && this.gameModel.getPiece(row, j) != null) {
                Position position = new Position(row, j);
                possibleTakes.add(position);
            }
        }
        return possibleTakes;
    }


}
