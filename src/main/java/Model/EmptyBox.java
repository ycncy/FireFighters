package Model;

import Util.Position;
import java.util.List;

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
