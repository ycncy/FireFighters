package Model.Manager;

import Util.Position;

public abstract class Manager {

    protected int amount;

    public Manager (int amount) {
        this.amount = amount;
    }

    public Position randomPosition(int rowCount, int colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    abstract void initialize (int rowCount, int colCount);
    abstract void update (int rowCount, int colCount);
}
