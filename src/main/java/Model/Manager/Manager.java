package Model.Manager;

import Model.Entity.Entity;
import Util.Position;

import java.util.Set;

public abstract class Manager {

    protected int amount;

    public Manager (int amount) {
        this.amount = amount;
    }

    public Position randomPosition(int rowCount, int colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public abstract Set<Entity> getEntities ();
    public abstract void initialize (int rowCount, int colCount);
    public abstract void update (int rowCount, int colCount);
}