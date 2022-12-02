package firefightersgame.model.obstacle.managers;

import firefightersgame.model.obstacle.obstacles.*;
import generalstructure.model.Position;
import generalstructure.model.obstacle.Obstacle;
import generalstructure.model.obstacle.ObstacleManager;
import java.util.*;

public class MountainManagers implements ObstacleManager {

    private final int amount;

    private final Set<Mountain> mountains = new HashSet<>();

    public MountainManagers(int amount) {
        this.amount = amount;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) {
            List<Position> nextPositions = new ArrayList<>();
            Position randomPosition = Position.randomPosition(rowCount, colCount);
            Position sidePosition = new Position(randomPosition.row() - 1, randomPosition.col());
            for (int current = 1; current < 10; current++) {
                nextPositions.add(new Position (randomPosition.row(), randomPosition.col() - current));
                nextPositions.add(new Position(sidePosition.row(), sidePosition.col() - current));
            }
            for (Position position : nextPositions) {
                if (contains(position) == null) mountains.add(new Mountain(position));
            }
        }
    }

    @Override
    public Set<Obstacle> getObstacles() {
        return new HashSet<>(mountains);
    }

    @Override
    public Mountain contains(Position position) {
        for (Mountain mountain : mountains) {
            if (mountain.getPosition().equals(position)) return mountain;
        }
        return null;
    }
}
