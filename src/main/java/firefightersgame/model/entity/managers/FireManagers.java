package firefightersgame.model.entity.managers;

import generalstructure.model.Position;
import firefightersgame.model.entity.entities.*;
import generalstructure.model.entity.*;
import generalstructure.model.obstacle.*;

import java.util.*;

public class FireManagers implements EntityManager, Extinguisher {

    private int step = 0;
    private final int amount;

    private final List<ObstacleManager> obstacleManagers;

    private Set<Fire> fires = new HashSet<>();

    public FireManagers(int amount, ObstacleManager... obstacleManagers) {
        this.amount = amount;
        this.obstacleManagers = List.of(obstacleManagers);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        upperfor:
        for (int i = 0; i < amount; i++) {
            Position potentialPosition = Position.randomPosition(rowCount, colCount);
            Fire potentialFire = new Fire(potentialPosition);
            for (ObstacleManager obstacleManager : obstacleManagers) {
                if (!obstacleManager.accept(potentialFire)) {
                    i--;
                    continue upperfor;
                }
            }
            fires.add(potentialFire);
        }
    }

    @Override
    public void update(int rowCount, int colCount) {
        if (step % 2 == 0) {
            Set<Fire> firesNewPositions = new HashSet<>();
            upperfor:
            for (Fire fire : fires) {
                Set<Position> newFires = new HashSet<>(fire.getPosition().next(rowCount, colCount));
                for (Position position : newFires) {
                    for (ObstacleManager obstacleManager : obstacleManagers) if (!obstacleManager.accept(new Fire(position))) continue upperfor;
                    firesNewPositions.add(new Fire(position));
                }
            }
            fires.addAll(firesNewPositions);
        }
        step++;
    }

    @Override
    public Fire containsFire(Position position) {
        for (Fire fire : fires) if (fire.getPosition().equals(position)) return fire;
        return null;
    }

    @Override
    public void extinguishFire(Fire fire) {
        fires.remove(fire);
    }

    @Override
    public Position aStepTowardFire(Position position, int rowCount, int colCount) {

        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(position.next(rowCount, colCount));

        for (Position initialMove : toVisit) firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (containsFire(current) != null) {
                for (ObstacleManager obstacleManager : obstacleManagers) {
                    if (!obstacleManager.accept(new FireFighter(current))) break;
                    return firstMove.get(current);
                }
            }

            upperfor:
            for (Position adjacent : current.next(rowCount, colCount)) {
                for (ObstacleManager obstacleManager : obstacleManagers) {
                    if (!obstacleManager.accept(new FireFighter(current))) break upperfor;
                    if (seen.contains(adjacent)) continue;
                    toVisit.add(adjacent);
                    seen.add(adjacent);
                    firstMove.put(adjacent, firstMove.get(current));
                }
            }
        }
        return position;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(fires);
    }
}
