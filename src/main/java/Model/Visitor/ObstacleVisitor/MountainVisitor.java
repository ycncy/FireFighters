package Model.Visitor.ObstacleVisitor;

import Model.Entity.Entities.*;
import Model.Obstacle.Manager.*;
import Util.Position;

public class MountainVisitor implements ObstacleVisitor {

    private final MountainManager mountainManager;

    public MountainVisitor (MountainManager mountainManager) {
        this.mountainManager = mountainManager;
    }

    @Override
    public boolean visitEmptyBox(EmptyBox emptyBox, Position position) {
        return mountainManager.contains(position) == null;
    }

    @Override
    public boolean visitFireFighter(FireFighter fireFighter, Position position) {
        return mountainManager.contains(position) == null;
    }

    @Override
    public boolean visitFire(Fire fire, Position position) {
        return mountainManager.contains(position) == null;
    }

    @Override
    public boolean visitCloud(Cloud cloud, Position position) {
        return mountainManager.contains(position) != null;
    }

    @Override
    public boolean visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter, Position position) {
        return mountainManager.contains(position) == null;
    }
}
