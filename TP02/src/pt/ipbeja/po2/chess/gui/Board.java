package pt.ipbeja.po2.chess.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pt.ipbeja.po2.chess.model.ChessBoard;
import pt.ipbeja.po2.chess.model.Pieces.Piece;
import pt.ipbeja.po2.chess.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Board extends VBox implements View {
    private int row, col, chosenPieces;
    private CellButton buttons[][];
    private ChessBoard gameModel;
    private GridPane gridPane = new GridPane();
    private Position pos;
    private List<Position> possibleMoves = new ArrayList<>();
    private List<Position> possibleTakes = new ArrayList<>();
    private List<Position> prevMoves = new ArrayList<>();

    /**
     * class constructor
     */
    public Board() {
        this.gameModel = new ChessBoard(this);
        this.drawBoard();
        this.getChildren().add(gridPane);
    }

    /**
     * draws the board with buttons
     */
    private void drawBoard() {
        chessHandler bh = new chessHandler();
        this.buttons = new CellButton[this.gameModel.getSIZE()][this.gameModel.getSIZE()];

        for (int row = 0; row < this.gameModel.getSIZE(); row++) {
            for (int col = 0; col < this.gameModel.getSIZE(); col++) {
                CellButton btn = new CellButton(row, col);
                this.buttons[row][col] = btn;
                btn.setOnAction(bh);
                this.gridPane.add(btn, col, row);
            }
        }
        this.updateButtonImages();
    }


    /**
     * set the image / text on the buttons
     */
    public void updateButtonImages() {
        this.buildPiecesLayOut();
        this.updateBoard();
    }

    private void updateBoard() {
        if (this.chosenPieces == 2) {
            this.updateWhiteImage();
            this.updateBlackImage();
        }
        if (this.chosenPieces == 1) {
            this.updateWhiteText();
            this.updateBlackText();
        }

    }

    /**
     * Asks user for an input given couple choices.
     *
     * @return the choice
     */
    private String choosePiecesLayOut() {
        String s = "";
        List<String> choices = new ArrayList<>();
        choices.add("Piece with text");
        choices.add("Piece with images");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Piece with images", choices);
        dialog.setTitle("Chess");
        dialog.setHeaderText("Choose between images or text pieces:");
        dialog.setContentText("Choose:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            s = result.get();
        }
        return s;
    }

    /**
     * Receives a string according to user choice and sets a variable with a new value.
     */
    private void buildPiecesLayOut() {
        String s = this.choosePiecesLayOut();
        if (s.equals("Piece with text")) {
            this.chosenPieces = 1;
        }
        if (s.equals("Piece with images")) {
            this.chosenPieces = 2;
        } else this.chosenPieces = 1;
    }


    private void highLightMoves() {

        if (!this.prevMoves.equals(possibleMoves)) {
            for (int i = 0; i < prevMoves.size(); i++) {
                int r = this.prevMoves.get(i).getLine();
                int c = this.prevMoves.get(i).getCol();
                this.buttons[r][c].removeHighLight();
            }
        }
        for (int i = 0; i < this.possibleMoves.size(); i++) {
            int row = this.possibleMoves.get(i).getLine();
            int col = this.possibleMoves.get(i).getCol();
            this.buttons[row][col].highLightMoves();
        }
        for (int i = 0; i < this.possibleTakes.size() ; i++) {
            int ro = this.possibleTakes.get(i).getLine();
            int co = this.possibleTakes.get(i).getCol();
            this.buttons[ro][co].highLightTakes();
        }


    }


    /**
     * Event handler
     */
    class chessHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            CellButton button = (CellButton) event.getSource();
            row = button.getRow();
            col = button.getCol();

            if (gameModel.getPiece(row, col) != null) {
                possibleTakes = gameModel.getPiece(row, col).possibleTakes();
                possibleMoves = gameModel.getPiece(row, col).possibleMoves();

                if (gameModel.getPiece(row, col).getType().equals("Pawn")) {
                    pawnSetUp();
                }
                if (gameModel.getPiece(row, col).getType().equals("Bishop")) {
                    bishopSetUp();
                }
                if (gameModel.getPiece(row, col).getType().equals("King")) {
                   kingSetUp();
                }
                if (gameModel.getPiece(row, col).getType().equals("Queen")) {
                    queenSetUp();
                }
                if (gameModel.getPiece(row, col).getType().equals("Rook")) {
                    rookSetUp();
                }
                if (gameModel.getPiece(row, col).getType().equals("Knight")) {
                    knightSetUp();
                }


                highLightMoves();

            }
            gameModel.clickPiece(row, col);
            prevMoves = possibleMoves;
            updateBoard();
        }
    }


    private void pawnSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhitePawn")) {
            System.out.println("Possible moves for White Pawn in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White Pawn in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black Pawn in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black Pawn in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }

    private void bishopSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhiteBishop")) {
            System.out.println("Possible moves for White Bishop in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White Bishop in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black Bishop in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black Bishop in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }

    private void kingSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhiteKing")) {
            System.out.println("Possible moves for White King in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White King in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black King in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black King in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }

    private void queenSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhiteQueen")) {
            System.out.println("Possible moves for White Queen in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White Queen in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black Queen in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black Queen in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }

    private void rookSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhiteRook")) {
            System.out.println("Possible moves for White Rook in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White Rook in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black Rook in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black Rook in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }

    private void knightSetUp() {
        if (gameModel.getPiece(row, col).getColorAndType().equals("WhiteKnight")) {
            System.out.println("Possible moves for White Knight in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for White Knight in " + "(" + row + "," + col + ") -> " + possibleTakes);

            //  System.out.println(gameModel.getPiece(row, col));
        } else {
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();
            System.out.println("Possible moves for Black Knight in " + "(" + row + "," + col + ") -> " + possibleMoves);
            System.out.println("Possible takes for Black Knight in " + "(" + row + "," + col + ") -> " + possibleTakes);
        }
    }


    /**
     * update the buttons where the white pieces are with images.
     */
    private void updateWhiteImage() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {
                if (this.gameModel.getPiece(i, j) == null) {
                    this.buttons[i][j].setEmpty();
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "WhiteRook":
                            this.buttons[i][j].setWhiteRook();
                            break;
                        case "WhitePawn":
                            this.buttons[i][j].setWhitePawn();
                            break;
                        case "WhiteKing":
                            this.buttons[i][j].setWhiteKing();
                            break;
                        case "WhiteQueen":
                            this.buttons[i][j].setWhiteQueen();
                            break;
                        case "WhiteBishop":
                            this.buttons[i][j].setWhiteBishop();
                            break;
                        case "WhiteKnight":
                            this.buttons[i][j].setWhiteHorse();
                            break;
                    }
                }
            }
        }
    }

    /**
     * update the buttons where the black pieces are with images.
     */
    private void updateBlackImage() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {
                if (this.gameModel.getPiece(i, j) == null) {
                    this.buttons[i][j].setEmpty();
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "BlackRook":
                            this.buttons[i][j].setBlackRook();
                            break;
                        case "BlackPawn":
                            this.buttons[i][j].setBlackPawn();
                            break;
                        case "BlackKing":
                            this.buttons[i][j].setBlackKing();
                            break;
                        case "BlackQueen":
                            this.buttons[i][j].setBlackQueen();
                            break;
                        case "BlackBishop":
                            this.buttons[i][j].setBlackBishop();
                            break;
                        case "BlackKnight":
                            this.buttons[i][j].setBlackHorse();
                            break;
                    }
                }
            }
        }
    }

    /**
     * update the buttons where the white pieces are with text.
     */
    private void updateWhiteText() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {
                if (this.gameModel.getPiece(i, j) == null) {
                    this.buttons[i][j].setText("");
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "WhiteRook":
                            this.buttons[i][j].setText("B T");
                            break;
                        case "WhitePawn":
                            this.buttons[i][j].setText("B p");
                            break;
                        case "WhiteKing":
                            this.buttons[i][j].setText("B R");
                            break;
                        case "WhiteQueen":
                            this.buttons[i][j].setText("B D");
                            break;
                        case "WhiteBishop":
                            this.buttons[i][j].setText("B B");
                            break;
                        case "WhiteKnight":
                            this.buttons[i][j].setText("B C");
                            break;
                    }
                }
            }
        }
    }

    /**
     * update the buttons where the black pieces are with text.
     */
    private void updateBlackText() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {
                if (this.gameModel.getPiece(i, j) == null) {
                    this.buttons[i][j].setText("");
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "BlackRook":
                            this.buttons[i][j].setText("P T");
                            break;
                        case "BlackPawn":
                            this.buttons[i][j].setText("P p");
                            break;
                        case "BlackKing":
                            this.buttons[i][j].setText("P R");
                            break;
                        case "BlackQueen":
                            this.buttons[i][j].setText("P D");
                            break;
                        case "BlackBishop":
                            this.buttons[i][j].setText("P B");
                            break;
                        case "BlackKnight":
                            this.buttons[i][j].setText("P C");
                            break;
                    }
                }
            }
        }
    }

    public Position getPos() {
        return this.pos;
    }
}

