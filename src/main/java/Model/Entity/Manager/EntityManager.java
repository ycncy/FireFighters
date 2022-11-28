package Model.Entity.Manager;

import Model.Entity.*;
import Model.Visitor.ObstacleVisitor.*;
import Util.*;
import java.util.*;

public abstract class EntityManager {

    protected int amount;
    protected List<ObstacleVisitor> obstacleVisitors = new ArrayList<>();

    public EntityManager(int amount, ObstacleVisitor... obstacleVisitors) {
        this.amount = amount;
        this.obstacleVisitors.addAll(List.of(obstacleVisitors));
    }

    public Position randomPosition(int rowCount, int colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public abstract void initialize (int rowCount, int colCount);
    public abstract void update (int rowCount, int colCount);
    public abstract Set<Entity> getEntities ();
}