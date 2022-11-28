package Model.Obstacle.Obstacles;

import Model.Obstacle.Obstacle;
import View.PaintingVistor.Visitor;
import Util.*;

public class Road extends Obstacle {

    public Road(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRoad(this);
    }
}
