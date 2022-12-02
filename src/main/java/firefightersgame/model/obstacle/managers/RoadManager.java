package firefightersgame.model.obstacle.managers;

import generalstructure.model.obstacle.ObstacleVisitor;
import firefightersgame.model.obstacle.obstacles.*;
import generalstructure.model.Position;
import generalstructure.model.obstacle.*;
import generalstructure.model.obstacle.ObstacleManager;
import java.util.*;

public class RoadManager implements ObstacleManager {

    private final int amount;

    private final Set<Road> roads = new HashSet<>();

    public RoadManager(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor) {
        return obstacleVisitor.visitRoad(this);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) {
            Random random = new Random();
            Road road = new Road(Position.randomPosition(rowCount, colCount));
            roads.add(road);
            for (int count = 0; count < random.nextInt(10); count++) {
                Road newRoad = new Road(new Position(road.getPosition().row() - 1, road.getPosition().col()));
                roads.add(newRoad);
                road = newRoad;
            }
        }
    }

    @Override
    public Set<Obstacle> getObstacles() {
        return new HashSet<>(roads);
    }

    @Override
    public boolean contains(Position position) {
        for (Road obstacle : roads) {
            if (obstacle.getPosition().equals(position)) return true;
        }
        return false;
    }
}
