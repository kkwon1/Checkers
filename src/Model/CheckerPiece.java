package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Kevin on 2015-08-24.
 */
public abstract class CheckerPiece extends JPanel {
    protected Color color;
    protected Grid grid;
    protected boolean selected;
    protected boolean isKing = false;
    protected static final int RADIUS = 100;

    public Grid getGrid() {
        return grid;
    }

    public Color getColor() {
        return color;
    }

    public boolean getSelected() {
        return selected;
    }

    public void select() {
        selected = true;
    }

    public void unselect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean hasGrid() {
        return (grid != null);
    }


    public void setKing(boolean b){
        isKing = b;
    }

    public void setGrid(Grid givenGrid) {
        if (givenGrid == null)
            grid = null;
        else if (givenGrid != null) {
            if (givenGrid != grid) {
                removeGrid();
                grid = givenGrid;
                givenGrid.setCheckerPiece(this);
            }
            if (givenGrid == this.grid)
                return;
        }
    }


    public void removeGrid() {
        if (grid != null) {
            if (grid.hasCheckerPiece()) {
                grid.setCheckerPiece(null);
                grid = null;
            }
        }
    }


    public abstract void move(Grid grid);

    public abstract Set<Grid> getLegalMoves();

    public abstract boolean isKing();


    public abstract void mousePressedOnBoard(MouseEvent e);


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CheckerPiece that = (CheckerPiece) o;
//
//        return !(grid != null ? !grid.equals(that.grid) : that.grid != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return grid != null ? grid.hashCode() : 0;
//    }
}
