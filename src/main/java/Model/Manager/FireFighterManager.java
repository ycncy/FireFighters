package Model.Manager;

import Model.Entity.*;
import Util.Position;
import java.util.*;

public class FireFighterManager extends Manager {

    private final Extinguisher extinguisher;

    public List<FireFighter> fireFighters = new ArrayList<>();

    public FireFighterManager (int amount, FireManager extinguisher) {
        super(amount);
        this.extinguisher = extinguisher;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) fireFighters.add(new FireFighter(randomPosition(rowCount, colCount)));
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
