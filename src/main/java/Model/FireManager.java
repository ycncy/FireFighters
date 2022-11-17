package Model;

import Util.Position;

import java.util.*;

public class FireManager {

    Model model;
    List<Position> fireNewPositions;
    Set<Position> fires = new HashSet<>();

    public FireManager (Model model) {
        this.model = model;
    }

    public void extinguish(Position position) {
        fires.remove(position);
        model.paintingVisitor.visitEmptyBox(new EmptyBox(new Position(position.row(), position.col())));
    }

    public Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(position, model.rowCount, model.colCount));

        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (fires.contains(current)) return firstMove.get(current);

            for (Position adjacent : position.next(current, model.rowCount, model.colCount)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}
