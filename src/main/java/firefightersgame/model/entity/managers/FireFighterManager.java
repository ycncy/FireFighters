package firefightersgame.model.entity.managers;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.model.Position;

import java.util.*;

public class FireFighterManager extends EntityManager {

    private final Extinguisher extinguisher;

    private List<FireFighter> fireFighters = new ArrayList<>();

    public FireFighterManager(int amount, Extinguisher extinguisher, ObstacleVisitor... obstacleVisitors) {
        super(amount, obstacleVisitors);
        this.extinguisher = extinguisher;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        int count = 0;
        whileloop:
        while (count < amount) {
            FireFighter fireFighter = new FireFighter(randomPosition(rowCount, colCount));
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!fireFighter.accept(obstacleVisitor, fireFighter.getPosition())) {
                    continue whileloop;
                }
            }
            fireFighters.add(fireFighter);
            count++;
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