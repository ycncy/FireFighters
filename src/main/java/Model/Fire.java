package Model;

import Util.Position;
import View.Grid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fire implements Entity {

    private Position position;

    public Fire (Position position) {
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
