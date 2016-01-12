package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Kevin on 2015-08-26.
 */
public class MouseEventDemo implements MouseListener {
    private Board board = Board.getInstance();
    private boolean whiteTurn = true;

    public MouseEventDemo() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point click = e.getPoint();
        Grid clickedGrid = board.getGridByPoint(click);
        CheckerPiece clickedPiece = clickedGrid.getPiece();

        if (clickedGrid.hasCheckerPiece() && !clickedPiece.isSelected()) {
            if (clickedPiece.getColor().equals(Color.white)) {
                if (board.getSelectedPiece()!= null && board.getSelectedPiece().getColor().equals(Color.red))
                    return;
                else if (whiteTurn) {
                    for (CheckerPiece next : board.getCheckerPieces()) {
                        if (next.isSelected()) {
                            next.mousePressedOnBoard(e);
                            next.unselect();
                        }
                    }
                    clickedPiece.mousePressedOnBoard(e);
                    clickedPiece.select();
                    whiteTurn = false;
                } else {
                    JOptionPane.showMessageDialog(null,"It is red's turn");
                    return;
                }


            } else if (clickedPiece.getColor().equals(Color.red)) {
                if (board.getSelectedPiece()!= null && board.getSelectedPiece().getColor().equals(Color.white))
                    return;
                else if (!whiteTurn) {
                    for (CheckerPiece next : board.getCheckerPieces()) {
                        if (next.isSelected()) {
                            next.mousePressedOnBoard(e);
                            next.unselect();
                        }
                    }
                    clickedPiece.mousePressedOnBoard(e);
                    clickedPiece.select();
                    whiteTurn = true;
                } else {
                    JOptionPane.showMessageDialog(null, "It is white's turn");
                    return;
                }
            }


        } else if (clickedGrid.hasCheckerPiece() && clickedPiece.isSelected()) {
            clickedPiece.mousePressedOnBoard(e);
            clickedPiece.unselect();
            whiteTurn = !whiteTurn;
        } else if (!clickedGrid.hasCheckerPiece() && !clickedGrid.isHighlighted())
            return;

        else if (!clickedGrid.hasCheckerPiece() && clickedGrid.isHighlighted()) {
            CheckerPiece selected = board.getSelectedPiece();
            moveToDestination(selected, e);

            if (selected.getColor().equals(Color.red)) {
                if (selected.getGrid().getGridPosition().getY() == 525 && !selected.isKing()) {
                    selected.setKing(true);
                }
            } else if (selected.getColor().equals(Color.white)) {
                if (selected.getGrid().getGridPosition().getY() == 0 && !selected.isKing()) {
                    selected.setKing(true);
                }
            }
            selected.unselect();
            resetBoardColors();
            board.checkGameOver();
        }

    }

    public void moveToDestination(CheckerPiece thePiece, MouseEvent e) {
        Point click = e.getPoint();
        Grid clickedGrid = board.getGridByPoint(click);
        Grid thePieceGrid = thePiece.getGrid();
        int thePieceX = (int) thePieceGrid.getGridPosition().getX();
        int thePieceY = (int) thePieceGrid.getGridPosition().getY();

        int clickedX = (int) clickedGrid.getGridPosition().getX();
        int clickedY = (int) clickedGrid.getGridPosition().getY();

        if (!thePiece.isKing()) {
            if (thePiece.getColor() == Color.red && clickedX > thePieceX + 75) {
                board.getGridByPoint(new Point(thePieceX + 75, thePieceY + 75)).removePiece();
                board.removeWhitePiece();

            } else if (thePiece.getColor() == Color.red && clickedX < thePieceX - 75) {
                board.getGridByPoint(new Point(thePieceX - 75, thePieceY + 75)).removePiece();
                board.removeWhitePiece();

            } else if (thePiece.getColor() == Color.white && clickedX > thePieceX + 75) {
                board.getGridByPoint(new Point(thePieceX + 75, thePieceY - 75)).removePiece();
                board.removeRedPiece();

            } else if (thePiece.getColor() == Color.white && clickedX < thePieceX - 75) {
                board.getGridByPoint(new Point(thePieceX - 75, thePieceY - 75)).removePiece();
                board.removeRedPiece();
            }
        }


        else if (thePiece.isKing()) {
            if (thePiece.getColor().equals(Color.red) && clickedY > thePieceY + 75) {
                if (clickedX > thePieceX + 75) {
                    board.getGridByPoint(new Point(thePieceX + 75, thePieceY + 75)).removePiece();
                    board.removeWhitePiece();

                } else if (clickedX < thePieceX - 75) {
                    board.getGridByPoint(new Point(thePieceX - 75, thePieceY + 75)).removePiece();
                    board.removeWhitePiece();
                }
            }
            else if (thePiece.getColor().equals(Color.red) && clickedY < thePieceY - 75) {
                if (clickedX > thePieceX + 75) {
                    board.getGridByPoint(new Point(thePieceX + 75, thePieceY - 75)).removePiece();
                    board.removeWhitePiece();
                }
                else if (clickedX < thePieceX - 75){
                    board.getGridByPoint(new Point(thePieceX - 75, thePieceY - 75)).removePiece();
                    board.removeWhitePiece();
                }
            }

            else if (thePiece.getColor().equals(Color.white) && clickedY < thePieceY - 75){
                if (clickedX > thePieceX + 75) {
                    board.getGridByPoint(new Point(thePieceX + 75, thePieceY - 75)).removePiece();
                    board.removeRedPiece();

                } else if (clickedX < thePieceX - 75) {
                    board.getGridByPoint(new Point(thePieceX - 75, thePieceY - 75)).removePiece();
                    board.removeRedPiece();
                }

            }
            else if (thePiece.getColor().equals(Color.white) && clickedY > thePieceY + 75){
                if (clickedX > thePieceX + 75) {
                    board.getGridByPoint(new Point(thePieceX + 75, thePieceY + 75)).removePiece();
                    board.removeRedPiece();
                }
                else if (clickedX < thePieceX - 75){
                    board.getGridByPoint(new Point(thePieceX - 75, thePieceY + 75)).removePiece();
                    board.removeRedPiece();
                }
            }
        }

        thePiece.setGrid(clickedGrid);

    }


    public void resetBoardColors() {
        for (Grid next : board.getAllGrids()) {
            next.setColor(next.getOriginalColor());
            next.unhighlight();
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
