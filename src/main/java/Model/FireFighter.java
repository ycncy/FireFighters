package Model;

import Util.*;
import View.*;

import java.util.*;

public class FireFighter extends Entity {

    public FireFighter (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireFighter(this);
    }
}
