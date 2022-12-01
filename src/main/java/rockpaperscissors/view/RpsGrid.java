package rockpaperscissors.view;

import generalstructure.model.Model;
import generalstructure.view.Grid;
import rockpaperscissors.model.managers.*;

public class RpsGrid extends Grid {

    public RpsGrid (int width, int height, int colCount, int rowCount) {
        super(width, height, colCount, rowCount);
    }

    @Override
    public void initialisation() {
        model = new Model(rowCount, colCount);
        RockManager rockManager = new RockManager(1);
        PaperManager paperManager = new PaperManager(1, rockManager);
        ScissorsManager scissorsManager = new ScissorsManager(1, paperManager);
        rockManager.addScissorsManager(scissorsManager);

        model.addAllEntityManagers(rockManager, paperManager, scissorsManager);

        model.initializeEntities();
        repaint();
    }
}
