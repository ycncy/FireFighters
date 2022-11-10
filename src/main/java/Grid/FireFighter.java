package Grid;

import Util.Position;

import java.util.List;

public class FireFighter implements Element {

    public Grid grid;
    public Position position;

    public FireFighter(Grid grid, Position position) {
        this.grid = grid;
        this.position = position;
    }

    @Override
    public void activate (Position position, Grid grid) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireFighter(this);
    }


}
