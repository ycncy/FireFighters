package generalstructure.model.obstacle;

import generalstructure.model.Position;
import java.util.Set;

public interface ObstacleManager {

    boolean accept (ObstacleVisitor obstacleVisitor);
    void initialize (int rowCount, int colCount);
    Set<Obstacle> getObstacles ();
    boolean contains (Position position);
}
