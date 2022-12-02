package firefightersgame.model.entity.entities;

import firefightersgame.model.obstacle.managers.MountainManager;
import firefightersgame.model.obstacle.managers.RoadManager;
import generalstructure.model.entity.Entity;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;

public class Cloud extends Entity implements ObstacleVisitor {

    public Cloud (Position position) {
        super(position);
    }

    @Override
    public void accept (PaintingVisitor paintingVisitor) {
        paintingVisitor.visitCloud (this);
    }

    @Override
    public boolean visitMountain(MountainManager mountainManager) {
        return true;
    }

    @Override
    public boolean visitRoad(RoadManager roadManager) {
        return true;
    }
}
