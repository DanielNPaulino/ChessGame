package pt.ipbeja.po2.chess.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return line == position.line &&
                col == position.col;
    }

    @Override
    public int hashCode() {

        return Objects.hash(line, col);
    }

    @Override
    public String toString() {
        return "Position{" +
                "line=" + line +
                ", col=" + col +
                '}';
    }
}