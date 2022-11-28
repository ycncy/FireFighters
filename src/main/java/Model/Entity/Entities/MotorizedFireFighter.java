package Model.Entity.Entities;

import Model.Entity.Entity;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import View.PaintingVistor.Visitor;
import Util.Position;

public class MotorizedFireFighter extends Entity {

    public MotorizedFireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMotorizedFireFighter (this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitMotorizedFireFighter(this, position);
    }
}
