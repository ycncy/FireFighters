package rockpaperscissors.model.managers;

import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.model.Position;
import rockpaperscissors.model.entities.*;

import java.util.*;

public class RockManager extends EntityManager {

    private ScissorsManager scissorsManager;

    private Set<Rock> rocks = new HashSet<>();

    public RockManager(int amount, ObstacleVisitor... obstacleVisitors) {
        super(amount, obstacleVisitors);
    }

    public void addScissorsManager (ScissorsManager scissorsManager) {
        this.scissorsManager = scissorsManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) rocks.add(new Rock(randomPosition(rowCount, colCount)));
    }

    @Override
    public void update(int rowCount, int colCount) {
        Set<Rock> updatedRocks = new HashSet<>();
        for (Rock rock : rocks) {
            updatedRocks.add(rock);
            List<Position> possibleNewPositions = new ArrayList<>(rock.getPosition().next(rowCount, colCount));
            for (Position position : possibleNewPositions) {
                updatedRocks.add(new Rock(position));
                if (scissorsManager.contains(position) != null) {
                    scissorsManager.killEntity(position);
                }
            }
        }
        rocks = updatedRocks;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(rocks);
    }

    public Rock contains(Position position) {
        for (Rock rock : rocks) if (rock.getPosition().equals(position)) return rock;
        return null;
    }

    public void killEntity(Position position) {
        rocks.remove(contains(position));
    }
}
