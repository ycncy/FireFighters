package firefightersgame.model.obstacle.managers;

import firefightersgame.model.obstacle.obstacles.Rockeries;
import generalstructure.model.Position;
import generalstructure.model.obstacle.Obstacle;
import generalstructure.model.obstacle.ObstacleManager;

import java.util.*;

public class RockeriesManagers implements ObstacleManager {

    private final int amount;

    private final Set<Rockeries> rockeries = new HashSet<>();

    public RockeriesManagers(int amount) {
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
                if (contains(position) == null) rockeries.add(new Rockeries(position));
            }
        }
    }

    @Override
    public Set<Obstacle> getObstacles() {
        return new HashSet<>(rockeries);
    }

    @Override
    public Rockeries contains(Position position) {
        for (Rockeries rockeriesElement : rockeries) {
            if (rockeriesElement.getPosition().equals(position)) return rockeriesElement;
        }
        return null;
    }
}
