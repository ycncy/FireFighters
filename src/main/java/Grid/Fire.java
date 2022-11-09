package Grid;

public class Fire implements Element {

    public Grid grid;
    public int row, col;

    public Fire(Grid grid, int row, int col) {
        this.grid = grid;
        this.row = row;
        this.col = col;
    }

    @Override
    public void accept(PaintingVisitor visitor) {
        visitor.visitFire(this);
    }
}
