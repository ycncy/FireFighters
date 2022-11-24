package Model.Manager;

import Model.Entity.*;
import Util.Position;

import java.util.*;

public class MotorizedFireFighterManager extends Manager {

    private Extinguisher extinguisher;

    private List<MotorizedFireFighter> motorizedFireFighters = new ArrayList<>();

    public MotorizedFireFighterManager(int amount, Extinguisher extinguisher) {
        super(amount);
        this.extinguisher = extinguisher;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) motorizedFireFighters.add(new MotorizedFireFighter(randomPosition(rowCount, colCount)));
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
