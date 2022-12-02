package firefightersgame.model.obstaclevisitor;

import firefightersgame.model.entity.entities.*;
import firefightersgame.model.obstacle.managers.*;
import generalstructure.model.Position;
import generalstructure.model.obstacle.ObstacleVisitor;

public class MountainVisitor implements ObstacleVisitor {

    private final MountainManager mountainManager;

    public MountainVisitor (MountainManager mountainManager) {
        this.mountainManager = mountainManager;
    }

    @Override
    public boolean visitEmptyBox(EmptyBox emptyBox, Position position) {
        return hasMountainAt(position);
    }

    private boolean hasMountainAt(Position position) {
        return mountainManager.contains(position) == null;
    }

    @Override
    public boolean visitFireFighter(FireFighter fireFighter, Position position) {
        return hasMountainAt(position);
    }

    @Override
    public boolean visitFire(Fire fire, Position position) {
        return hasMountainAt(position);
    }

    @Override
    public boolean visitCloud(Cloud cloud, Position position) {
        return !hasMountainAt(position);
    }

    @Override
    public boolean visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter, Position position) {
        return hasMountainAt(position);
    }
}
