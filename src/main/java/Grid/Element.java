package Grid;

import Model.Model;
import Util.Position;

import java.util.List;

public interface Element {
    List<Element> activate(Grid grid, Model model);
    void accept(Visitor visitor);
}
