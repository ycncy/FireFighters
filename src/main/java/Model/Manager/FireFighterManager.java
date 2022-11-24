package Model.Manager;

import Model.Entity.FireFighter;
import Util.Position;

import java.util.*;

public class FireFighterManager extends Manager {

    private final Extinguisher fireManager;

    public List<FireFighter> fireFighters = new ArrayList<>();

    public FireFighterManager (int amount, FireManager fireManager) {
        super(amount);
        this.fireManager = fireManager;
    }

    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) fireFighters.add(new FireFighter(randomPosition(rowCount, colCount)));
    }

    public void update(int rowCount, int colCount) {
        List<FireFighter> fireFightersNewPositions = new ArrayList<>();
        for (FireFighter fireFighter : fireFighters) {
            Position randomPosition = fireManager.aStepTowardFire(fireFighter.getPosition(), rowCount, colCount);
            List<Position> nextFires = randomPosition.next(rowCount, colCount);
            fireManager.extinguish(fireManager.containsFire(randomPosition));
            for (Position fire : nextFires) {
                fireManager.extinguish(fireManager.containsFire(fire));
            }
            fireFightersNewPositions.add(new FireFighter(randomPosition));
        }
        fireFighters = fireFightersNewPositions;
    }
}
