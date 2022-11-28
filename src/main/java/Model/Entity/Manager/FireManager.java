package Model.Entity.Manager;

import Model.Entity.*;
import Model.Entity.Entities.*;
import Model.Visitor.ObstacleVisitor.*;
import Util.*;

import java.util.*;

public class FireManager extends EntityManager implements Extinguisher {

    private int step = 0;

    private Set<Fire> fires = new HashSet<>();

    public FireManager(int amount, ObstacleVisitor... obstacleVisitors) {
        super(amount, obstacleVisitors);
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        int count = 0;
        whileloop:
        while (count < amount) {
            Fire fire = new Fire(randomPosition(rowCount, colCount));
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!fire.accept(obstacleVisitor, fire.getPosition())) {
                    continue whileloop;
                }
            }
            fires.add(fire);
            count++;
        }
    }

    @Override
    public void update(int rowCount, int colCount) {
        if (step % 2 == 0) {
            Set<Fire> firesNewPositions = new HashSet<>();
            for (Fire fire : fires) {
                Set<Position> newFires = new HashSet<>();
                newFires.addAll(fire.next(rowCount, colCount, obstacleVisitors));
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
    public void extinguishFire(Fire fire) {
        fires.remove(fire);
    }

    @Override
    public Position aStepTowardFire(Position position, int rowCount, int colCount) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(rowCount, colCount));

        for (Position initialMove : toVisit) firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (containsFire(current) != null) {
                for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                    if (!obstacleVisitor.visitFireFighter(new FireFighter(current), current)) {
                        break;
                    }
                    return firstMove.get(current);
                }
            }

            mainfor:
            for (Position adjacent : current.next(rowCount, colCount)) {
                if (seen.contains(adjacent)) continue;
                for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                    if (!obstacleVisitor.visitFireFighter(new FireFighter(current), current)) {
                        continue mainfor;
                    }
                    toVisit.add(adjacent);
                    seen.add(adjacent);
                    firstMove.put(adjacent, firstMove.get(current));
                }
            }
        }
        return position;
    }
}
