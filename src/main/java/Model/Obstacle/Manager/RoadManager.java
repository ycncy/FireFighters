package Model.Obstacle.Manager;

import Model.Obstacle.Obstacle;
import Model.Obstacle.Obstacles.Road;
import Util.Position;

import java.util.*;

public class RoadManager extends ObstacleManager {

    private final Set<Road> roads = new HashSet<>();

    public RoadManager(int amount) {
        super(amount);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) {
            Random random = new Random();
            Road road = new Road(randomPosition(rowCount, colCount));
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
    public Obstacle contains(Position position) {
        for (Obstacle obstacle : roads) {
            if (obstacle.getPosition().equals(position)) return obstacle;
        }
        return null;
    }
}
