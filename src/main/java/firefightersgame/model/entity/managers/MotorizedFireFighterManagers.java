package firefightersgame.model.entity.managers;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.Entity;
import generalstructure.model.entity.EntityManager;
import generalstructure.model.Position;
import generalstructure.model.obstacle.ObstacleManager;
import java.util.*;

public class MotorizedFireFighterManagers implements EntityManager {

    private final Extinguisher extinguisher;

    private final int amount;

    private List<MotorizedFireFighter> motorizedFireFighters = new ArrayList<>();
    private final List<ObstacleManager> obstacleManagers;

    public MotorizedFireFighterManagers(int amount, Extinguisher extinguisher, ObstacleManager... obstacleManagers) {
        this.amount = amount;
        this.extinguisher = extinguisher;
        this.obstacleManagers = List.of(obstacleManagers);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        upperfor:
        for (int i = 0; i < amount; i++) {
            Position potentialPosition = Position.randomPosition(rowCount, colCount);
            MotorizedFireFighter potentialMotorizedFireFighter = new MotorizedFireFighter(potentialPosition);
            for (ObstacleManager obstacleManager : obstacleManagers) {
                if (obstacleManager.contains(potentialPosition) && !obstacleManager.accept(potentialMotorizedFireFighter)) {
                    i--;
                    continue upperfor;
                }
            }
            motorizedFireFighters.add(potentialMotorizedFireFighter);
        }
    }

    @Override
    public void update(int rowCount, int colCount) {
        List<MotorizedFireFighter> motorizedFireFightersNewPositions = new ArrayList<>();
        for (MotorizedFireFighter motorizedFireFighter : motorizedFireFighters) {
            Position randomPosition = extinguisher.aStepTowardFire(motorizedFireFighter.getPosition(), rowCount, colCount);
            List<Position> nextFires = randomPosition.next(rowCount, colCount);
            extinguisher.extinguishFire(extinguisher.containsFire(randomPosition));
            for (Position fire : nextFires) {
                extinguisher.extinguishFire(extinguisher.containsFire(fire));
            }

            Position newRandomPosition = extinguisher.aStepTowardFire(randomPosition, rowCount, colCount);
            List<Position> newNexFires = newRandomPosition.next(rowCount, colCount);
            extinguisher.extinguishFire(extinguisher.containsFire(newRandomPosition));
            for (Position fire : newNexFires) {
                extinguisher.extinguishFire(extinguisher.containsFire(fire));
            }
            motorizedFireFightersNewPositions.add(new MotorizedFireFighter(newRandomPosition));
        }
        motorizedFireFighters = motorizedFireFightersNewPositions;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(motorizedFireFighters);
    }
}
