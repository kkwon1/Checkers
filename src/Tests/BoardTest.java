package Tests;

import Model.CheckerPiece;
import Model.Exceptions.OutOfBoardException;
import Model.Grid;
import Model.Board;
import java.util.List;

import Model.RedPiece;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Eric on 2016-05-05.
 */
public class BoardTest {

    private Board board;
    CheckerPiece redcp;
    CheckerPiece whitecp;
    CheckerPiece redcpl;

    @Before
    public void setUp() throws Exception {
        // initial setup board
        board = Board.getInstance();
        List<CheckerPiece> cps = board.getCheckerPieces();
        // red checker piece with no legal moves
        redcp = cps.get(0);
        // white checker piece with 1 legal move
        whitecp = cps.get(12);
    }

    @Test
    public void testCorrectNumberOfPieces() {
        assertEquals(24, board.getCheckerPieces().size());
    }

    @Test
    public void testCorrectNumberOfGrids() {
        assertEquals(64, board.getAllGrids().size());
    }

    @Test
    public void testCheckerPieceCorrectColor() {
        assertEquals(redcp.getColor(), Color.red);
        assertEquals(whitecp.getColor(), Color.white);
    }

    @Test
    public void testCheckerPieceOnCorrectGrid() {
        assertEquals(redcp.getGrid().getColor(), Color.black);
        assertEquals(whitecp.getGrid().getColor(), Color.black);
    }

    @Test
    public void testCheckerPieceNotKingNotSelected() {
        assertFalse(whitecp.isKing());
        assertFalse(whitecp.isSelected());
    }

    @Test
    public void testCheckerPieceKingAndSelected() {
        redcp.select();
        redcp.setKing(true);
        assertTrue(redcp.isSelected());
        assertTrue(redcp.isKing());
        assertEquals(redcp, board.getSelectedPiece());
    }

    @Test (expected = OutOfBoardException.class)
    public void testIllegalCheckerPieceMove() throws OutOfBoardException {
        Grid start = new Grid(Color.black, new Point(0,0));
        Grid destination = new Grid(Color.black, new Point(1000,1000));
        CheckerPiece cp = new RedPiece(start);
        cp.move(destination);
    }

    @Test
    public void testLegalCheckerPieceMove() {
        Grid start = new Grid(Color.black, new Point(0,0));
        Grid destination = new Grid(Color.black, new Point(100,100));
        CheckerPiece cp = new RedPiece(start);
        try {
            cp.move(destination);
        } catch (OutOfBoardException e) {
            fail(e.getMessage());
        }
        assertEquals(destination, cp.getGrid());
    }

    @Test
    public void testCheckerPieceLegalMoves() {
        assertEquals(0, redcp.getLegalMoves().size());
        assertEquals(1, whitecp.getLegalMoves().size());

        Grid B4 = board.getAllGrids().get(11);
        Grid B5 = board.getAllGrids().get(12);
        assertTrue(whitecp.getLegalMoves().contains(B5));
        assertFalse(whitecp.getLegalMoves().contains(B4));
    }
}