package Grid;

import Model.Model;
import Util.Position;

import java.util.ArrayList;
import java.util.List;

public class Fire implements Element {

    public Grid grid;
    public Position position;

    public Fire(Grid grid, Position position) {
        this.grid = grid;
        this.position = position;
    }

    @Override
    public List<Element> activate (Grid grid, Model model) {
        if (model.getStep() % 2 == 0) {
            List<Element> newFires = new ArrayList<>();
            for (Position newPosition : position.next(position, grid)) {
                newFires.add(new Fire(grid, newPosition));
            }
            newFires.add(this);
            return newFires;
        }
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }
}
