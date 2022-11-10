package Grid;

import Util.Position;

public class EmptyCase implements Element {

    public Grid grid;
    public Position position;

    public EmptyCase(Grid grid, Position position) {
        this.grid = grid;
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyCase(this);
    }
}
