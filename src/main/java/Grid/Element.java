package Grid;

import Util.Position;

public interface Element {
    void activate(Position position, Grid grid);
    void accept(Visitor visitor);
}
