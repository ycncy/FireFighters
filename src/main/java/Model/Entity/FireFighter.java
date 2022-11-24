package Model.Entity;

import Model.Visitor.Visitor;
import Util.*;

public class FireFighter extends Entity {

    public FireFighter (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireFighter(this);
    }
}
