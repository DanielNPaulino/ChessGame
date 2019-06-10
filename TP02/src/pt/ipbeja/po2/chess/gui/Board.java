package pt.ipbeja.po2.chess.gui;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pt.ipbeja.po2.chess.model.ChessBoard;
import pt.ipbeja.po2.chess.model.PlayerColor;
import pt.ipbeja.po2.chess.model.Position;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Filipe Gonçalves (6050), Daniel Paulino (14056)
 * @version 29/05/2019
 */
public class Board extends VBox implements View {
    private int row, col, prevRow, prevCol, chosenPieces;
    private CellButton buttons[][];
    private ChessBoard gameModel;
    private GridPane gridPane = new GridPane();
    private Position pos;
    private PlayerColor playerColor;
    private List<Position> possibleMoves = new ArrayList<>();
    private List<Position> possibleTakes = new ArrayList<>();

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
    @Override
    public void updateButtonImages() {
        this.buildPiecesLayOut();
        if (this.chosenPieces == 2) {
            this.updateWhiteImage();
            this.updateBlackImage();
        }
        if (this.chosenPieces == 1) {
            this.updateWhiteText();
            this.updateBlackText();
        }
    }

    private void updateBoard() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {


            }
        }
    }


    /**
     * update the buttons where the white pieces are with images.
     */
    private void updateWhiteImage() {
        for (int i = 0; i < this.gameModel.getSIZE(); i++) {
            for (int j = 0; j < this.gameModel.getSIZE(); j++) {
                if (this.gameModel.getPiece(i, j) == null) {
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "White Rook":
                            this.buttons[i][j].setWhiteRook();
                            break;
                        case "White Pawn":
                            this.buttons[i][j].setWhitePawn();
                            break;
                        case "White King":
                            this.buttons[i][j].setWhiteKing();
                            break;
                        case "White Queen":
                            this.buttons[i][j].setWhiteQueen();
                            break;
                        case "White Bishop":
                            this.buttons[i][j].setWhiteBishop();
                            break;
                        case "White Knight":
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
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "Black Rook":
                            this.buttons[i][j].setBlackRook();
                            break;
                        case "Black Pawn":
                            this.buttons[i][j].setBlackPawn();
                            break;
                        case "Black King":
                            this.buttons[i][j].setBlackKing();
                            break;
                        case "Black Queen":
                            this.buttons[i][j].setBlackQueen();
                            break;
                        case "Black Bishop":
                            this.buttons[i][j].setBlackBishop();
                            break;
                        case "Black Knight":
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
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "White Rook":
                            this.buttons[i][j].setText("B T");
                            break;
                        case "White Pawn":
                            this.buttons[i][j].setText("B p");
                            break;
                        case "White King":
                            this.buttons[i][j].setText("B R");
                            break;
                        case "White Queen":
                            this.buttons[i][j].setText("B D");
                            break;
                        case "White Bishop":
                            this.buttons[i][j].setText("B B");
                            break;
                        case "White Knight":
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
                } else {
                    switch (this.gameModel.getPiece(i, j).getColorAndType()) {
                        case "Black Rook":
                            this.buttons[i][j].setText("P T");
                            break;
                        case "Black Pawn":
                            this.buttons[i][j].setText("P p");
                            break;
                        case "Black King":
                            this.buttons[i][j].setText("P R");
                            break;
                        case "Black Queen":
                            this.buttons[i][j].setText("P D");
                            break;
                        case "Black Bishop":
                            this.buttons[i][j].setText("P B");
                            break;
                        case "Black Knight":
                            this.buttons[i][j].setText("P C");
                            break;
                    }
                }
            }
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

        for (int i = 0; i < this.possibleMoves.size(); i++) {
            int row = this.possibleMoves.get(i).getLine();
            int col = this.possibleMoves.get(i).getCol();
            this.buttons[row][col].highLightMoves();
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
            possibleTakes = gameModel.getPiece(row, col).possibleTakes();
            possibleMoves = gameModel.getPiece(row, col).possibleMoves();

            if (gameModel.getPiece(row, col) != null) {
                if (gameModel.getPiece(row, col).getColorAndType().equals("White Pawn")) {


                    System.out.println("Possible moves for White Pawn in " + "(" + row + "," + col + ") -> " + possibleMoves);
                    System.out.println("Possible takes for White Pawn in " + "(" + row + "," + col + ") -> " + possibleTakes);
                    //  System.out.println(gameModel.getPiece(row, col));
                } else {
                    possibleMoves = gameModel.getPiece(row, col).possibleMoves();
                    System.out.println("Possible moves for Black Pawn in " + "(" + row + "," + col + ") -> " + possibleMoves);
                    System.out.println("Possible takes for Black Pawn in " + "(" + row + "," + col + ") -> " + possibleTakes);
                }
                highLightMoves();
            }
            // System.out.println(Arrays.deepToString(gameModel.dataBoard));
        }
    }
}

