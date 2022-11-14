package Model;

import Util.Position;
import View.Grid;

import java.util.HashSet;
import java.util.Set;

public class EmptyBox implements Entity {

    private Position position;

    public EmptyBox (Position position) {
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyBox(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
