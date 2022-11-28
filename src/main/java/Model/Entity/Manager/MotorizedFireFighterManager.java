package Model.Entity.Manager;

import Model.Entity.*;
import Model.Entity.Entities.FireFighter;
import Model.Entity.Entities.MotorizedFireFighter;
import Model.Visitor.ObstacleVisitor.ObstacleVisitor;
import Util.Position;

import java.util.*;

public class MotorizedFireFighterManager extends EntityManager {

    private final Extinguisher extinguisher;

    private List<MotorizedFireFighter> motorizedFireFighters = new ArrayList<>();

    public MotorizedFireFighterManager(int amount, Extinguisher extinguisher, ObstacleVisitor... obstacleVisitors) {
        super(amount, obstacleVisitors);
        this.extinguisher = extinguisher;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        int count = 0;
        whileloop:
        while (count < amount) {
            MotorizedFireFighter motorizedFireFighter = new MotorizedFireFighter(randomPosition(rowCount, colCount));
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!motorizedFireFighter.accept(obstacleVisitor, motorizedFireFighter.getPosition())) {
                    continue whileloop;
                }
            }
            motorizedFireFighters.add(motorizedFireFighter);
            count++;
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
