package Model;

import Util.Position;
import View.Grid;
import java.util.Set;

public interface Entity {

    void accept (Visitor visitor);
    Position getPosition ();
}
