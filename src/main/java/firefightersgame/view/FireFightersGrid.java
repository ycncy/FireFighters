package firefightersgame.view;

import firefightersgame.model.entity.managers.*;
import generalstructure.model.Model;
import firefightersgame.model.obstacle.managers.*;
import firefightersgame.model.obstaclevisitor.*;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.Grid;

public class FireFightersGrid extends Grid {

    protected ObstacleVisitor mountainVisitor;
    protected ObstacleVisitor roadVisitor;

    public FireFightersGrid(int width, int height, int colCount, int rowCount) {
        super(width, height, colCount, rowCount);
    }

    @Override
    public void initialisation() {
        model = new Model(rowCount, colCount);
        //CRÉATION DES OBSTACLES
        MountainManager mountainManager = new MountainManager(2);
        RoadManager roadManager = new RoadManager(2);

        model.addAllObstacleManagers(mountainManager, roadManager);
        model.initializeObstacles();

        mountainVisitor = new MountainVisitor(mountainManager);
        roadVisitor = new RoadVisitor(roadManager);

        //CRÉATION DES ENTITÉS
        FireManager fireManager = new FireManager(1, mountainVisitor, roadVisitor);
        FireFighterManager fireFighterManager = new FireFighterManager(1, fireManager, mountainVisitor, roadVisitor);
        CloudManager cloudManager = new CloudManager(1, fireManager, mountainVisitor, roadVisitor);
        MotorizedFireFighterManager motorizedFireFighterManager = new MotorizedFireFighterManager(1, fireManager, mountainVisitor, roadVisitor);

        model.addAllEntityManagers(fireManager, fireFighterManager, cloudManager, motorizedFireFighterManager);
        model.initializeEntities();

        repaint();
    }
}
