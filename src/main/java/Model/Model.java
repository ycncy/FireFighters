package Model;

import Model.Manager.FireFighterManager;
import Model.Manager.FireManager;

public class Model {

    int colCount, rowCount;

    public FireManager fireManager;
    public FireFighterManager fireFighterManager;

    public Model(int rowCount, int colCount) {
        this.fireManager = new FireManager(3);
        this.fireFighterManager = new FireFighterManager(8, fireManager);
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public void initialisation() {
        fireManager.initialize(rowCount, colCount);
        fireFighterManager.initialize(rowCount, colCount);
    }

    public void activation() {
        fireManager.update(rowCount, colCount);
        fireFighterManager.update(rowCount, colCount);
    }
}
