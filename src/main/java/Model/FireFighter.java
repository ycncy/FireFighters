package Model;

import Util.*;
import View.*;

import java.util.*;

public class FireFighter implements Entity {

    private Position position;

    public FireFighter (Position position) {
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireFighter(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
