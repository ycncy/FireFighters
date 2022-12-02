package firefightersgame.model.obstacle.obstacles;

import generalstructure.model.obstacle.Obstacle;
import generalstructure.view.paintingvisitor.PaintingVisitor;
import generalstructure.model.Position;

public class Mountain extends Obstacle {

    public Mountain (Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitMountain(this);
    }
}
