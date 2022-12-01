package firefightersgame.model.entity.entities;

import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

public class EmptyBox extends Entity {

    public EmptyBox(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitEmptyBox(this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitEmptyBox(this, position);
    }
}
