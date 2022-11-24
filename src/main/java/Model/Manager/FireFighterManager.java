package Model.Manager;

import Model.Entity.FireFighter;
import Util.Position;

import java.util.*;

public class FireFighterManager extends Manager {

    private final FireManager fireManager;

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
            Position randomPosition = fireFighter.aStepTowardFire(fireFighter.getPosition(), fireManager, rowCount, colCount);
            List<Position> nextFires = randomPosition.next(rowCount, colCount);
            fireFighter.extinguish(fireManager.containsFire(randomPosition), fireManager);
            for (Position fire : nextFires) {
                fireFighter.extinguish(fireManager.containsFire(fire), fireManager);
            }
            fireFightersNewPositions.add(new FireFighter(randomPosition));
        }
        fireFighters = fireFightersNewPositions;
    }
}
