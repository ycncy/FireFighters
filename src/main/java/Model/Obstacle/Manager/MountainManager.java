package Model.Obstacle.Manager;

import Model.Obstacle.*;
import Model.Obstacle.Obstacles.Mountain;
import Util.Position;

import java.util.*;

public class MountainManager extends ObstacleManager {

    private final Set<Mountain> mountains = new HashSet<>();

    public MountainManager (int amount) {
        super(amount);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) {
            List<Position> nextPositions = new ArrayList<>();
            Position randomPosition = randomPosition(rowCount, colCount);
            Position sidePosition = new Position(randomPosition.row() - 1, randomPosition.col());
            for (int current = 1; current < 10; current++) {
                nextPositions.add(new Position (randomPosition.row(), randomPosition.col() - current));
                nextPositions.add(new Position(sidePosition.row(), sidePosition.col() - current));
            }
            for (Position position : nextPositions) {
                if (contains(position) == null) mountains.add(new Mountain(position));
            }
        }
        obstacles.addAll(mountains);
    }

    @Override
    public Set<Obstacle> getObstacles() {
        return new HashSet<>(mountains);
    }

    @Override
    public Obstacle contains(Position position) {
        for (Mountain mountain : mountains) {
            if (mountain.getPosition().equals(position)) return mountain;
        }
        return null;
    }
}
