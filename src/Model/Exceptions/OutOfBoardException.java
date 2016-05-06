package Model.Exceptions;

/**
 * Created by Eric on 2016-05-05.
 */
public class OutOfBoardException extends Exception {

    public OutOfBoardException() {
        super("Piece attempted to move to illegal location");
    }
}
