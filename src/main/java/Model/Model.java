package Model;

import Util.Position;
import View.*;
import java.util.*;

public class Model {

    Grid grid;
    int colCount, rowCount;
    List<Position> firefighters = new ArrayList<>();
    Set<Position> fires = new HashSet<>();
    List<Position> ffNewPositions;
    Visitor paintingVisitor;
    int step = 0;

    public Model(Grid grid) {
        this.grid = grid;
        colCount = grid.getColCount();
        rowCount = grid.getRowCount();
        paintingVisitor = new PaintingVisitor(grid);
    }

    public void initialisation(int fireNumber, int fireFighterNumber) {
        for (int index = 0; index < fireNumber; index++)
            fires.add(randomPosition());
        for (int index = 0; index < fireFighterNumber; index++)
            firefighters.add(randomPosition());
    }

    private Position randomPosition() {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public void activation() {
        ffNewPositions = new ArrayList<>();
        for (Position ff : firefighters) {
            Position newPosition = activateFirefighter(ff);
            paintingVisitor.visitEmptyBox(new EmptyBox(new Position(ff.row(), ff.col())));
            paintingVisitor.visitFireFighter(new FireFighter(new Position(newPosition.row(), newPosition.col())));
            ffNewPositions.add(newPosition);
        }
        firefighters = ffNewPositions;
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : fires) {
                newFires.addAll(activateFire(fire));
            }
            for (Position newFire : newFires)
                paintingVisitor.visitFire(new Fire(new Position(newFire.row(), newFire.col())));
            fires.addAll(newFires);
        }
        step++;

    }

    private List<Position> activateFire(Position position) {
        return position.next(position, rowCount, colCount);
    }

    private Position activateFirefighter(Position position) {
        Position randomPosition = aStepTowardFire(position);
        //next(position).get((int) (Math.random()*next(position).size()));
        List<Position> nextFires = position.next(randomPosition, rowCount, colCount).stream().filter(fires::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }

    private void extinguish(Position position) {
        fires.remove(position);
        paintingVisitor.visitEmptyBox(new EmptyBox(new Position(position.row(), position.col())));
    }

    /*
    private List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < rowCount - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < colCount - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }*/

    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(position, rowCount, colCount));

        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);

        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();

            if (fires.contains(current)) return firstMove.get(current);

            for (Position adjacent : position.next(current, rowCount, colCount)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}
