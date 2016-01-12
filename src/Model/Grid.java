package Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kevin on 2015-08-24.
 */
public class Grid extends JPanel {
    private CheckerPiece piece;
    private Point gridPosition;
    private Color color;
    private Color originalColor;
    private boolean isHighlighted;

    public Grid(Color color, Point position) {
        gridPosition = position;
        this.color = color;
        originalColor = color;
    }


    public Color getColor() {
        return color;
    }

    public Color getOriginalColor() {
        return originalColor;
    }

    public Point getGridPosition() {
        return gridPosition;
    }

    public CheckerPiece getPiece() {
        return piece;
    }


    public void setCheckerPiece(CheckerPiece checkerPiece) {
        if (checkerPiece == null)
            piece = null;
        else if (checkerPiece != null) {
            if (checkerPiece != piece) {
                removePiece();
                piece = checkerPiece;
                checkerPiece.setGrid(this);
            } else if (checkerPiece == piece)
                return;
        }
    }

    public void removePiece() {
        if (piece != null) {
            if (piece.hasGrid()) {
                piece.setGrid(null);
                piece = null;
            }
        }

    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void highlight() {
        isHighlighted = true;
        setColor(Color.green);
    }

    public void unhighlight() {
        isHighlighted = false;
        setColor(originalColor);
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setPieceBackground() {
        setBackground(Color.black);
    }

    public boolean hasCheckerPiece() {
        return (piece != null);
    }

    public boolean isEmpty() {
        return (piece == null);
    }

    public boolean contains(double x, double y) {
        double gridX = gridPosition.getX();
        double gridY = gridPosition.getY();

        if (x >= gridX && x < gridX + 100 && y >= gridY && y < gridY + 100) {
            return true;
        }

        return false;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Grid grid = (Grid) o;
//
//        return !(gridPosition != null ? !gridPosition.equals(grid.gridPosition) : grid.gridPosition != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return gridPosition != null ? gridPosition.hashCode() : 0;
//    }
}
