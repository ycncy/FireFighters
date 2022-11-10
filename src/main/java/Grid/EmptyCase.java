package Grid;

import Model.Model;
import Util.Position;

import java.util.List;

public class EmptyCase implements Element {

    public Grid grid;
    public Position position;

    public EmptyCase(Grid grid, Position position) {
        this.grid = grid;
        this.position = position;
    }


    @Override
    public List<Element> activate(Grid grid, Model model) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyCase(this);
    }
}
