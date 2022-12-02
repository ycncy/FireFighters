package firefightersgame.model.entity.entities;

import firefightersgame.model.obstacle.managers.MountainManager;
import firefightersgame.model.obstacle.managers.RoadManager;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

public class FireFighter extends Entity implements ObstacleVisitor {

    public FireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitFireFighter(this);
    }

    @Override
    public boolean visitMountain(MountainManager mountainManager) {
        return !mountainManager.contains(position);
    }

    @Override
    public boolean visitRoad(RoadManager roadManager) {
        return true;
    }
}
