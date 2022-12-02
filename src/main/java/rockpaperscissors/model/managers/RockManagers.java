package rockpaperscissors.model.managers;

import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.Position;
import rockpaperscissors.model.entities.*;

import java.util.*;

public class RockManagers implements EntityManager {

    private ScissorsManagers scissorsManager;

    private final int amount;

    private Set<Rock> rocks = new HashSet<>();

    public RockManagers(int amount) {
        this.amount = amount;
    }

    public void addScissorsManager (ScissorsManagers scissorsManager) {
        this.scissorsManager = scissorsManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) rocks.add(new Rock(Position.randomPosition(rowCount, colCount)));
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

    public void killEntity(Position position) {
        rocks.remove(contains(position));
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(rocks);
    }

    public Rock contains(Position position) {
        for (Rock rock : rocks) if (rock.getPosition().equals(position)) return rock;
        return null;
    }
}
