package generalstructure.model.obstacle;

import generalstructure.model.Position;
import java.util.Set;

public interface ObstacleManager {

    void initialize (int rowCount, int colCount);
    Set<Obstacle> getObstacles ();
    Obstacle contains (Position position);
}
