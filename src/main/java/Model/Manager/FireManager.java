package Model.Manager;

import Model.Entity.Entity;
import Model.Entity.Fire;
import Util.Position;

import java.util.*;

public class FireManager extends Manager implements Extinguisher{

    private int step = 0;

    public Set<Fire> fires = new HashSet<>();

    public FireManager (int amount) {
        super(amount);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) fires.add(new Fire(randomPosition(rowCount, colCount)));
    }

    @Override
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

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(fires);
    }

    @Override
    public Fire containsFire(Position position) {
        for (Fire fire : fires) if (fire.getPosition().equals(position)) return fire;
        return null;
    }

    @Override
    public void extinguishFire (Fire fire) {
        fires.remove(fire);
    }

    @Override
    public Position aStepTowardFire (Position position, int rowCount, int colCount) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(rowCount, colCount));

        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (containsFire(current) != null) return firstMove.get(current);

            for (Position adjacent : current.next(rowCount, colCount)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}
