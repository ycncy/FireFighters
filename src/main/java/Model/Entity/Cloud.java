package Model.Entity;

import Model.Visitor.Visitor;
import Util.Position;

public class Cloud extends Entity {

    public Cloud(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCloud (this);
    }
}
