package Model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eric on 2015-08-24.
 */
public class WhitePiece extends CheckerPiece {

    public WhitePiece(Grid grid) {
        setGrid(grid);
        this.color = Color.white;
    }

    public boolean isKing() {
        return isKing;
    }


    @Override
    public void mousePressedOnBoard(MouseEvent e) {
        if (!this.isSelected()) {
            for (Grid next : this.getLegalMoves()) {
                if (next != null)
                    if (!next.hasCheckerPiece())
                      next.highlight();
            }
        } else {
            for (Grid next : this.getLegalMoves()) {
                if (next != null)
                    next.unhighlight();
            }
        }
    }


    @Override
    public void move(Grid grid) {

    }

    @Override
    public Set<Grid> getLegalMoves() {
        Set<Grid> legalMoves = new HashSet<>();

        // create a set of legal moves for a specific white piece

        int leftX = (int) this.getGrid().getGridPosition().getX() - 75;
        int rightX = (int) this.getGrid().getGridPosition().getX() + 75;
        int leftXHop = (int) this.getGrid().getGridPosition().getX() - 150;
        int rightXHop = (int) this.getGrid().getGridPosition().getX() + 150;
        int newY = (int) this.getGrid().getGridPosition().getY() - 75;
        int newYHop = (int) this.getGrid().getGridPosition().getY() - 150;
        int kingY = (int) this.getGrid().getGridPosition().getY() + 75;
        int kingYHop = (int) this.getGrid().getGridPosition().getY() + 150;

        Grid leftGrid = null;
        Grid rightGrid = null;


        if (leftX >= 0 && newY >= 0)
            leftGrid = Board.getInstance().getGridByPoint(new Point(leftX, newY));
        if (rightX <= 525 && newY >= 0)
            rightGrid = Board.getInstance().getGridByPoint(new Point(rightX, newY));

        if (leftGrid != null) {
            if (leftGrid.hasCheckerPiece()) {
                if (leftGrid.getPiece().getColor() == Color.white) {
                    leftGrid = null;
                }
                else if (leftGrid.getPiece().getColor() == Color.red){
                    if (leftXHop >= 0 && newYHop >=0)
                        leftGrid = Board.getInstance().getGridByPoint(new Point(leftXHop, newYHop));
                    else
                        leftGrid = null;
                }
            }
        }

        if (rightGrid != null) {
            if (rightGrid.hasCheckerPiece()) {
                if (rightGrid.getPiece().getColor() == Color.white) {
                    rightGrid = null;
                }
                else if (rightGrid.getPiece().getColor() == Color.red){
                    if (rightXHop <= 525 && newYHop >=0)
                        rightGrid = Board.getInstance().getGridByPoint(new Point(rightXHop, newYHop));
                    else
                        rightGrid = null;
                }
            }
        }

        if (leftGrid != null) {
            if (leftGrid.getGridPosition().getX() >= 0 && leftGrid.getGridPosition().getY() >= 0) {
                legalMoves.add(leftGrid);
            }
        }

        if (rightGrid != null) {
            if (rightGrid.getGridPosition().getX() <= 525 && rightGrid.getGridPosition().getY() >= 0) {
                legalMoves.add(rightGrid);
            }
        }

        if (isKing()) {
            if (leftX >= 0 && newY <= 525)
                leftGrid = Board.getInstance().getGridByPoint(new Point(leftX, kingY));
            if (rightX <= 525 && newY <= 525)
                rightGrid = Board.getInstance().getGridByPoint(new Point(rightX, kingY));

            if (leftGrid != null) {
                if (leftGrid.hasCheckerPiece()) {
                    if (leftGrid.getPiece().getColor() == Color.white) {
                        leftGrid = null;
                    } else if (leftGrid.getPiece().getColor() == Color.red) {
                        if (leftXHop >= 0 && newYHop <= 525) {
                            leftGrid = Board.getInstance().getGridByPoint(new Point(leftXHop, kingYHop));
                        } else
                            leftGrid = null;
                    }
                }
            }

            if (rightGrid != null) {
                if (rightGrid.hasCheckerPiece()) {
                    if (rightGrid.getPiece().getColor() == Color.white) {
                        rightGrid = null;
                    } else if (rightGrid.getPiece().getColor() == Color.red) {
                        if (rightXHop <= 525 && newYHop <= 525)
                            rightGrid = Board.getInstance().getGridByPoint(new Point(rightXHop, kingYHop));
                        else
                            rightGrid = null;
                    }
                }
            }


            if (leftGrid != null) {
                if (leftGrid.getGridPosition().getX() >= 0 && leftGrid.getGridPosition().getY() <= 525) {
                    legalMoves.add(leftGrid);
                }
            }

            if (rightGrid != null) {
                if (rightGrid.getGridPosition().getX() <= 525 && rightGrid.getGridPosition().getY() <= 525) {
                    legalMoves.add(rightGrid);
                }
            }
        }

        return legalMoves;
    }
}
