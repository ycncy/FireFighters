package firefightersgame.model.obstacle.obstacles;

import generalstructure.model.obstacle.Obstacle;
import generalstructure.view.paintingvisitor.PaintingVisitor;
import generalstructure.model.Position;

public class Road extends Obstacle {

    public Road(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitRoad(this);
    }
}
