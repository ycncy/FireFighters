package Model.Entity;

import Model.Manager.FireManager;
import View.Visitor;
import Util.Position;

import java.util.*;

public abstract class Entity {

    protected Position position;

    public Entity(Position position) {
        this.position = position;
    }

    abstract void accept (Visitor visitor);

    public void extinguish (Fire fire, FireManager fireManager) {
        fireManager.removeFire(fire);
    }

    public Position aStepTowardFire (Position position, FireManager fireManager, int rowCount, int colCount) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(rowCount, colCount));

        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (fireManager.containsFire(current) != null) return firstMove.get(current);

            for (Position adjacent : current.next(rowCount, colCount)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }

    public Position getPosition () {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return position != null ? position.equals(entity.position) : entity.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
