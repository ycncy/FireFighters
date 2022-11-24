package Model;

import Util.Position;
import java.util.List;

public class EmptyBox extends Entity {

    public EmptyBox (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyBox(this);
    }
}
