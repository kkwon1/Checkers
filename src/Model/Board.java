package Model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Kevin on 2015-08-24.
 */
public class Board extends JPanel {
    private static List<CheckerPiece> checkerPieces;
    private static List<Grid> allGrids;
    private static Board board;
    private static int numRedPieces;
    private static int numWhitePieces;

    private static final Color WHITE = Color.LIGHT_GRAY;
    private static final Color BLACK = Color.black;
    private static MouseEventDemo med = new MouseEventDemo();

    private final Grid A1 = new Grid(WHITE, new Point(0, 0));
    private final Grid B1 = new Grid(BLACK, new Point(75, 0));
    private final Grid C1 = new Grid(WHITE, new Point(150, 0));
    private final Grid D1 = new Grid(BLACK, new Point(225, 0));
    private final Grid E1 = new Grid(WHITE, new Point(300, 0));
    private final Grid F1 = new Grid(BLACK, new Point(375, 0));
    private final Grid G1 = new Grid(WHITE, new Point(450, 0));
    private final Grid H1 = new Grid(BLACK, new Point(525, 0));

    private final Grid A2 = new Grid(BLACK, new Point(0, 75));
    private final Grid B2 = new Grid(WHITE, new Point(75, 75));
    private final Grid C2 = new Grid(BLACK, new Point(150, 75));
    private final Grid D2 = new Grid(WHITE, new Point(225, 75));
    private final Grid E2 = new Grid(BLACK, new Point(300, 75));
    private final Grid F2 = new Grid(WHITE, new Point(375, 75));
    private final Grid G2 = new Grid(BLACK, new Point(450, 75));
    private final Grid H2 = new Grid(WHITE, new Point(525, 75));

    private final Grid A3 = new Grid(WHITE, new Point(0, 150));
    private final Grid B3 = new Grid(BLACK, new Point(75, 150));
    private final Grid C3 = new Grid(WHITE, new Point(150, 150));
    private final Grid D3 = new Grid(BLACK, new Point(225, 150));
    private final Grid E3 = new Grid(WHITE, new Point(300, 150));
    private final Grid F3 = new Grid(BLACK, new Point(375, 150));
    private final Grid G3 = new Grid(WHITE, new Point(450, 150));
    private final Grid H3 = new Grid(BLACK, new Point(525, 150));

    private final Grid A4 = new Grid(BLACK, new Point(0, 225));
    private final Grid B4 = new Grid(WHITE, new Point(75, 225));
    private final Grid C4 = new Grid(BLACK, new Point(150, 225));
    private final Grid D4 = new Grid(WHITE, new Point(225, 225));
    private final Grid E4 = new Grid(BLACK, new Point(300, 225));
    private final Grid F4 = new Grid(WHITE, new Point(375, 225));
    private final Grid G4 = new Grid(BLACK, new Point(450, 225));
    private final Grid H4 = new Grid(WHITE, new Point(525, 225));

    private final Grid A5 = new Grid(WHITE, new Point(0, 300));
    private final Grid B5 = new Grid(BLACK, new Point(75, 300));
    private final Grid C5 = new Grid(WHITE, new Point(150, 300));
    private final Grid D5 = new Grid(BLACK, new Point(225, 300));
    private final Grid E5 = new Grid(WHITE, new Point(300, 300));
    private final Grid F5 = new Grid(BLACK, new Point(375, 300));
    private final Grid G5 = new Grid(WHITE, new Point(450, 300));
    private final Grid H5 = new Grid(BLACK, new Point(525, 300));

    private final Grid A6 = new Grid(BLACK, new Point(0, 375));
    private final Grid B6 = new Grid(WHITE, new Point(75, 375));
    private final Grid C6 = new Grid(BLACK, new Point(150, 375));
    private final Grid D6 = new Grid(WHITE, new Point(225, 375));
    private final Grid E6 = new Grid(BLACK, new Point(300, 375));
    private final Grid F6 = new Grid(WHITE, new Point(375, 375));
    private final Grid G6 = new Grid(BLACK, new Point(450, 375));
    private final Grid H6 = new Grid(WHITE, new Point(525, 375));

    private final Grid A7 = new Grid(WHITE, new Point(0, 450));
    private final Grid B7 = new Grid(BLACK, new Point(75, 450));
    private final Grid C7 = new Grid(WHITE, new Point(150, 450));
    private final Grid D7 = new Grid(BLACK, new Point(225, 450));
    private final Grid E7 = new Grid(WHITE, new Point(300, 450));
    private final Grid F7 = new Grid(BLACK, new Point(375, 450));
    private final Grid G7 = new Grid(WHITE, new Point(450, 450));
    private final Grid H7 = new Grid(BLACK, new Point(525, 450));

    private final Grid A8 = new Grid(BLACK, new Point(0, 525));
    private final Grid B8 = new Grid(WHITE, new Point(75, 525));
    private final Grid C8 = new Grid(BLACK, new Point(150, 525));
    private final Grid D8 = new Grid(WHITE, new Point(225, 525));
    private final Grid E8 = new Grid(BLACK, new Point(300, 525));
    private final Grid F8 = new Grid(WHITE, new Point(375, 525));
    private final Grid G8 = new Grid(BLACK, new Point(450, 525));
    private final Grid H8 = new Grid(WHITE, new Point(525, 525));


    private Board() {
        checkerPieces = new ArrayList<>();

        CheckerPiece R1 = new RedPiece(B1);
        CheckerPiece R2 = new RedPiece(D1);
        CheckerPiece R3 = new RedPiece(F1);
        CheckerPiece R4 = new RedPiece(H1);
        CheckerPiece R5 = new RedPiece(A2);
        CheckerPiece R6 = new RedPiece(C2);
        CheckerPiece R7 = new RedPiece(E2);
        CheckerPiece R8 = new RedPiece(G2);
        CheckerPiece R9 = new RedPiece(B3);
        CheckerPiece R10 = new RedPiece(D3);
        CheckerPiece R11 = new RedPiece(F3);
        CheckerPiece R12 = new RedPiece(H3);

        CheckerPiece W1 = new WhitePiece(A6);
        CheckerPiece W2 = new WhitePiece(C6);
        CheckerPiece W3 = new WhitePiece(E6);
        CheckerPiece W4 = new WhitePiece(G6);
        CheckerPiece W5 = new WhitePiece(B7);
        CheckerPiece W6 = new WhitePiece(D7);
        CheckerPiece W7 = new WhitePiece(F7);
        CheckerPiece W8 = new WhitePiece(H7);
        CheckerPiece W9 = new WhitePiece(A8);
        CheckerPiece W10 = new WhitePiece(C8);
        CheckerPiece W11 = new WhitePiece(E8);
        CheckerPiece W12 = new WhitePiece(G8);

        checkerPieces.add(R1);
        checkerPieces.add(R2);
        checkerPieces.add(R3);
        checkerPieces.add(R4);
        checkerPieces.add(R5);
        checkerPieces.add(R6);
        checkerPieces.add(R7);
        checkerPieces.add(R8);
        checkerPieces.add(R9);
        checkerPieces.add(R10);
        checkerPieces.add(R11);
        checkerPieces.add(R12);

        checkerPieces.add(W1);
        checkerPieces.add(W2);
        checkerPieces.add(W3);
        checkerPieces.add(W4);
        checkerPieces.add(W5);
        checkerPieces.add(W6);
        checkerPieces.add(W7);
        checkerPieces.add(W8);
        checkerPieces.add(W9);
        checkerPieces.add(W10);
        checkerPieces.add(W11);
        checkerPieces.add(W12);


        allGrids = new ArrayList<Grid>();

        allGrids.add(A1);
        allGrids.add(A2);
        allGrids.add(A3);
        allGrids.add(A4);
        allGrids.add(A4);
        allGrids.add(A5);
        allGrids.add(A6);
        allGrids.add(A7);
        allGrids.add(A8);

        allGrids.add(B1);
        allGrids.add(B2);
        allGrids.add(B3);
        allGrids.add(B4);
        allGrids.add(B5);
        allGrids.add(B6);
        allGrids.add(B7);
        allGrids.add(B8);

        allGrids.add(C1);
        allGrids.add(C2);
        allGrids.add(C3);
        allGrids.add(C4);
        allGrids.add(C5);
        allGrids.add(C6);
        allGrids.add(C7);
        allGrids.add(C8);

        allGrids.add(D1);
        allGrids.add(D2);
        allGrids.add(D3);
        allGrids.add(D4);
        allGrids.add(D5);
        allGrids.add(D6);
        allGrids.add(D7);
        allGrids.add(D8);

        allGrids.add(E1);
        allGrids.add(E2);
        allGrids.add(E3);
        allGrids.add(E4);
        allGrids.add(E5);
        allGrids.add(E6);
        allGrids.add(E7);
        allGrids.add(E8);

        allGrids.add(F1);
        allGrids.add(F2);
        allGrids.add(F3);
        allGrids.add(F4);
        allGrids.add(F5);
        allGrids.add(F6);
        allGrids.add(F7);
        allGrids.add(F8);

        allGrids.add(G1);
        allGrids.add(G2);
        allGrids.add(G3);
        allGrids.add(G4);
        allGrids.add(G5);
        allGrids.add(G6);
        allGrids.add(G7);
        allGrids.add(G8);

        allGrids.add(H1);
        allGrids.add(H2);
        allGrids.add(H3);
        allGrids.add(H4);
        allGrids.add(H5);
        allGrids.add(H6);
        allGrids.add(H7);
        allGrids.add(H8);
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }


    public List<CheckerPiece> getCheckerPieces() {
        return checkerPieces;
    }

    public List<Grid> getAllGrids() {
        return allGrids;
    }

    public Grid getGridByPoint(Point p) {
        Grid gridToReturn = null;

        for (Grid next : allGrids) {
            if (next.contains(p.getX(), p.getY())) {
                gridToReturn = next;
            }
        }

        return gridToReturn;
    }

    public CheckerPiece getSelectedPiece() {
        for (CheckerPiece next : checkerPieces) {
            if (next.isSelected())
                return next;
        }
        return null;
    }

    public static JPanel updateBoard() {
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Grid next : allGrids) {
                    int x = (int) next.getGridPosition().getX();
                    int y = (int) next.getGridPosition().getY();

                    g.setColor(next.getColor());
                    g.fillRect(x, y, 75, 75);

                    if (next.hasCheckerPiece()) {
                        g.setColor(next.getPiece().getColor());
                        g.fillOval(x, y, 75, 75);
                        if (next.getPiece().isSelected()){
                            g.setColor(new Color(41, 243, 26));
                            g.drawRect(x,y,75,75);
                        }
                        if (next.getPiece().isKing()) {
                            g.setColor(BLACK);
                            g.setFont(new Font("Arial", Font.BOLD, 30));
                            g.drawString("King", x + 7, y + 40);

                        }
                    }
                }
                repaint();
            }
        };

        for (Grid next : allGrids) {
            if (next.isHighlighted())
                next.setColor(Color.green);
        }

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(600, 600));
        return panel;
    }


    public static void main(String[] args) {
        JFrame boardFrame = new JFrame();
        numRedPieces = 12;
        numWhitePieces = 12;
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel board = new Board();
        board.add(updateBoard());

        boardFrame.add(board);
        boardFrame.pack();
        boardFrame.setLocationRelativeTo(null);
        boardFrame.setVisible(true);


        board.addMouseListener(med);



    }

    public void removeRedPiece() {
        numRedPieces--;
    }

    public void removeWhitePiece() {
        numWhitePieces--;
    }

    public static void checkGameOver() {
        if (numRedPieces == 0) {
            JOptionPane.showMessageDialog(null, "White wins, red has no more pieces");
            System.exit(0);
        } else if (numWhitePieces == 0) {
            JOptionPane.showMessageDialog(null, "Red wins, white has no more pieces");
            System.exit(0);
        }
    }

}