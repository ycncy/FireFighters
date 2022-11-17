package Model;

import Util.Position;
import java.util.List;

public interface Entity {

    void accept (Visitor visitor);
    Position getPosition ();
}
