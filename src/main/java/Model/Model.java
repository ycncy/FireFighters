package Model;

import Grid.*;
import java.util.*;
import Util.*;

public class Model {

    private Grid grid;
    private double colCount;
    private double rowCount;
    private List<Element> elements = new ArrayList<>();
    private List<Position> firefighters = new ArrayList<>();
    private Set<Position> fires = new HashSet<>();
    private List<Position> ffNewPositions;
    private int step = 0;
    private Visitor paintingVisitor = new PaintingVisitor();

    public Model(Grid grid) {
        this.grid = grid;
        colCount = grid.getColCount();
        rowCount = grid.getRowCount();
    }

    public void initialisation(int fireNumber, int fireFighterNumber) {
        for (int index = 0; index < fireNumber; index++)
            elements.add(new Fire(grid, randomPosition()));
        for (int index = 0; index < fireFighterNumber; index++)
            elements.add(new FireFighter(grid, randomPosition()));
    }

    private Position randomPosition() {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public void activation() {
        ffNewPositions = new ArrayList<>();
        for (Element element : elements) {
            element.active();
            element.accept(paintingVisitor);
        }
        for (Position ff : firefighters) {
            Position newPosition = activateFirefighter(ff);
            paintingVisitor.visitEmptyCase(new EmptyCase(grid, new Position(ff.row(), ff.col())));
            paintingVisitor.visitFireFighter(new FireFighter(grid, new Position(newPosition.row(), newPosition.col())));
            ffNewPositions.add(newPosition);
        }
        firefighters = ffNewPositions;
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : fires) {
                newFires.addAll(activateFire(fire));
            }
            for (Position newFire : newFires)
                paintingVisitor.visitFire(new Fire(grid, new Position(newFire.row(), newFire.col())));
            fires.addAll(newFires);
        }
        step++;
    }

    private List<Position> activateFire(Position position) {
        return position.next(position, grid);
    }

    private Position activateFirefighter(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = position.next(randomPosition, grid).stream().filter(fires::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }

    private void extinguish(Position position) {
        fires.remove(position);
        paintingVisitor.visitEmptyCase(new EmptyCase(grid, new Position(position.row(), position.col())));
    }

    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(position.next(position, grid));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (fires.contains(current))
                return firstMove.get(current);
            for (Position adjacent : position.next(current, grid)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}