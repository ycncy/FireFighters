package Model.Obstacle.Obstacles;

import Model.Obstacle.Obstacle;
import View.PaintingVistor.Visitor;
import Util.*;

public class Mountain extends Obstacle {

    public Mountain (Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMountain(this);
    }
}
