package Model.Visitor.ObstacleVisitor;

import Model.Entity.Entities.*;
import Model.Obstacle.Manager.*;
import Util.Position;

public class RoadVisitor implements ObstacleVisitor {

    private final RoadManager roadManager;

    public RoadVisitor (RoadManager roadManager) {
        this.roadManager = roadManager;
    }

    @Override
    public boolean visitEmptyBox(EmptyBox emptyBox, Position position) {
        return roadManager.contains(position) == null;
    }

    @Override
    public boolean visitFireFighter(FireFighter fireFighter, Position position) {
        return true;
    }

    @Override
    public boolean visitFire(Fire fire, Position position) {
        return roadManager.contains(position) == null;
    }

    @Override
    public boolean visitCloud(Cloud cloud, Position position) {
        return roadManager.contains(position) == null;
    }

    @Override
    public boolean visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter, Position position) {
        return true;
    }
}
