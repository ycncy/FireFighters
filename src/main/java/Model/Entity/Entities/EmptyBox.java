package Model.Entity.Entities;

import Model.Entity.Entity;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import View.PaintingVistor.Visitor;
import Util.Position;

public class EmptyBox extends Entity {

    public EmptyBox(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmptyBox(this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitEmptyBox(this, position);
    }
}
