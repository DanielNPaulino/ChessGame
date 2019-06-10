package pt.ipbeja.po2.xadrez.model.Pieces;


import pt.ipbeja.po2.xadrez.model.ChessBoard;
import pt.ipbeja.po2.xadrez.model.PlayerColor;
import pt.ipbeja.po2.xadrez.model.Position;

import java.util.List;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public abstract class Piece {

    private ChessBoard chessBoard;
    private Position position;
    private PlayerColor playerColor;

    public Piece(ChessBoard board, PlayerColor playerColor, Position position){
        this.chessBoard = board;
        this.position = position;
        this.playerColor = playerColor;
    }

    public abstract List<Position> possibleMoves();

    public abstract List<Position> possibleTakes();

    public abstract String getColorAndType();




}
