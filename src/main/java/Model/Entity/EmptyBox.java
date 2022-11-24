package Model.Entity;

import View.Visitor;
import Util.Position;

public class EmptyBox extends Entity {

    public EmptyBox (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyBox(this);
    }
}
