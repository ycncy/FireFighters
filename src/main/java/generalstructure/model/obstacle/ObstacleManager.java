package generalstructure.model.obstacle;

import generalstructure.model.Position;
import java.util.*;

public abstract class ObstacleManager {

    protected final int amount;
    protected Set<Obstacle> obstacles = new HashSet<>();

    public ObstacleManager (int amount) {
        this.amount = amount;
    }

    public abstract void initialize (int rowCount, int colCount);

    public Position randomPosition(int rowCount, int colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public abstract Set<Obstacle> getObstacles ();
    public abstract Obstacle contains (Position position);
}
