package Grid;

public class FireFighter implements Element {

    public Grid grid;
    public int row, col;

    public FireFighter(Grid grid, int row, int col) {
        this.grid = grid;
        this.row = row;
        this.col = col;
    }

    @Override
    public void accept(PaintingVisitor visitor) {
        visitor.visitFireFighter(this);
    }
}
