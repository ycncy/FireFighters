package firefightersgame.view;

import firefightersgame.model.entity.managers.*;
import generalstructure.model.Model;
import firefightersgame.model.obstacle.managers.*;
import generalstructure.view.Grid;

public class FireFightersGrid extends Grid {

    public FireFightersGrid(int width, int height, int colCount, int rowCount) {
        super(width, height, colCount, rowCount);
    }

    @Override
    public void initialisation() {
        model = new Model(rowCount, colCount);
        //CRÉATION DES OBSTACLES
        MountainManagers mountainManager = new MountainManagers(2);
        RoadManagers roadManager = new RoadManagers(2);

        model.addAllObstacleManagers(mountainManager, roadManager);
        model.initializeObstacles();

        //CRÉATION DES ENTITÉS
        FireManagers fireManager = new FireManagers(1);
        FireFighterManagers fireFighterManager = new FireFighterManagers(1, fireManager);
        CloudManagers cloudManager = new CloudManagers(1, fireManager);
        MotorizedFireFighterManagers motorizedFireFighterManager = new MotorizedFireFighterManagers(1, fireManager);

        model.addAllEntityManagers(fireManager, fireFighterManager, cloudManager, motorizedFireFighterManager);
        model.initializeEntities();

        repaint();
    }
}
