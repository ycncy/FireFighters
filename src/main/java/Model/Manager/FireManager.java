package Model.Manager;

import Model.Entity.Fire;
import Util.Position;

import java.util.*;

public class FireManager extends Manager {

    private int step = 0;

    public Set<Fire> fires = new HashSet<>();

    public FireManager (int amount) {
        super(amount);
    }

    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) fires.add(new Fire(randomPosition(rowCount, colCount)));
    }

    public void update(int rowCount, int colCount) {
        if (step % 2 == 0) {
            Set<Fire> firesNewPositions = new HashSet<>();
            for (Fire fire : fires) {
                List<Position> newFires = new ArrayList<>(fire.getPosition().next(rowCount, colCount));
                for (Position position : newFires) {
                    firesNewPositions.add(new Fire(position));
                }
            }
            fires.addAll(firesNewPositions);
        }
        step++;
    }

    public void removeFire(Fire fire) {
        fires.remove(fire);
    }

    public Fire containsFire(Position position) {
        for (Fire fire : fires) if (fire.getPosition().equals(position)) return fire;
        return null;
    }
}
