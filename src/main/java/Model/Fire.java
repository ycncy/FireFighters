package Model;

import Util.Position;

import java.util.List;

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
