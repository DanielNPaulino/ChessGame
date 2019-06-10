package pt.ipbeja.po2.xadrez.model;

import pt.ipbeja.po2.xadrez.gui.View;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Position {
    private final int line, col;

    public Position(int line, int col) {
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + line + ", " + col + ")";
    }

    /**
     * @return the line
     */
    public int getLine() {
        return this.line;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return this.col;
    }


    /**
     * Checks if position is inside the board
     *
     * @return true if inside, false otherwise
     */
    public boolean isInside() {
        return Position.isInside(this.getLine(), this.getCol());
    }

    /**
     * Checks if line col are inside tha board
     *
     * @param line
     * @param col
     * @return true if inside, false otherwise
     */
    public static boolean isInside(int line, int col) {
        return 0 <= line && line < 8 &&
                0 <= col && col < 8;
    }
}