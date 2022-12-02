package generalstructure.model.obstacle;

import firefightersgame.model.obstacle.managers.*;

public interface ObstacleVisitor {

    boolean visitMountain (MountainManager mountainManager);
    boolean visitRoad (RoadManager roadManager);
}
