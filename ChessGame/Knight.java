public class Knight extends Piece {
    public Knight(int x, int y, Player owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        return( Math.abs(getX() - destination.getX()) == 2 && Math.abs(getY()- destination.getY()) == 1)
                ||(Math.abs(getX() - destination.getX()) == 1 && Math.abs(getY()- destination.getY()) == 2);

    }

    @Override
    public Type getType() {
        return Type.KNIGHT;
    }

    @Override
    public int getValue() {
        return 3;
    }
}
