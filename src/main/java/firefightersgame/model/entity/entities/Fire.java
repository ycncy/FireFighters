package firefightersgame.model.entity.entities;

import firefightersgame.model.obstacle.managers.MountainManager;
import firefightersgame.model.obstacle.managers.RoadManager;
import firefightersgame.model.obstacle.managers.RockeriesManager;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

public class Fire extends Entity implements ObstacleVisitor {

    public Fire(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitFire(this);
    }

    @Override
    public boolean visitMountain(MountainManager mountainManager) {
        return false;
    }

    @Override
    public boolean visitRoad(RoadManager roadManager) {
        return false;
    }
}
