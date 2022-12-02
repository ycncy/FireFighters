package firefightersgame.model.obstacle.obstacles;

import generalstructure.model.Position;
import generalstructure.model.obstacle.Obstacle;
import generalstructure.view.paintingvisitor.PaintingVisitor;

public class Rockeries extends Obstacle {

    public Rockeries (Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        //paintingVisitor.visitRockeries (this);
    }
}
