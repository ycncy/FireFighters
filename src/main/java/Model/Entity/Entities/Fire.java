package Model.Entity.Entities;

import Model.Entity.Entity;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import View.PaintingVistor.Visitor;
import Util.*;

public class Fire extends Entity {

    public Fire(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitFire(this, position);
    }
}
