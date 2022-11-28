package Model.Entity.Entities;

import Model.Entity.Entity;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import View.PaintingVistor.Visitor;
import Util.Position;

public class Cloud extends Entity {

    public Cloud(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCloud (this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitCloud(this, position);
    }
}
