package Model.Entity;

import View.Visitor;
import Util.Position;

public class Fire extends Entity {

    public Fire (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }
}
