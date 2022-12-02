package firefightersgame.model.entity.managers;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.Position;
import generalstructure.model.obstacle.ObstacleManager;

import java.util.*;

public class FireFighterManagers implements EntityManager {

    private final Extinguisher extinguisher;
    private final List<ObstacleManager> obstacleManagers;

    private final int amount;

    private List<FireFighter> fireFighters = new ArrayList<>();

    public FireFighterManagers(int amount, Extinguisher extinguisher, ObstacleManager... obstacleManagers) {
        this.amount = amount;
        this.extinguisher = extinguisher;
        this.obstacleManagers = List.of(obstacleManagers);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        upperfor:
        for (int i = 0; i < amount; i++) {
            Position potentialPosition = Position.randomPosition(rowCount, colCount);
            FireFighter potentialFireFighter = new FireFighter(potentialPosition);
            for (ObstacleManager obstacleManager : obstacleManagers) {
                if (obstacleManager.contains(potentialPosition) && obstacleManager.accept(potentialFireFighter)) {
                    i--;
                    continue upperfor;
                }
            }
            fireFighters.add(potentialFireFighter);
        }
    }

    @Override
    public void update(int rowCount, int colCount) {
        List<FireFighter> fireFightersNewPositions = new ArrayList<>();
        for (FireFighter fireFighter : fireFighters) {
            Position randomPosition = extinguisher.aStepTowardFire(fireFighter.getPosition(), rowCount, colCount);
            List<Position> nextFires = randomPosition.next(rowCount, colCount);
            extinguisher.extinguishFire(extinguisher.containsFire(randomPosition));
            for (Position fire : nextFires) {
                extinguisher.extinguishFire(extinguisher.containsFire(fire));
            }
            fireFightersNewPositions.add(new FireFighter(randomPosition));
        }
        fireFighters = fireFightersNewPositions;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(fireFighters);
    }
}
