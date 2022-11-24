package Model;

import Util.Position;

import java.util.List;

public class Fire extends Entity {

    public Fire (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }
}
