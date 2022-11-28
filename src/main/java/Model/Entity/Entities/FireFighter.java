package Model.Entity.Entities;

import Model.Entity.Entity;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import View.PaintingVistor.Visitor;
import Util.*;

public class FireFighter extends Entity {

    public FireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireFighter(this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitFireFighter(this, position);
    }
}
