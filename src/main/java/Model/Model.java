package Model;

import Util.Position;
import View.*;
import java.util.*;

public class Model {

    Grid grid;
    FireManager fireManager;
    int colCount, rowCount;
    List<Position> firefighters = new ArrayList<>();
    List<Position> ffNewPositions;
    Visitor paintingVisitor;
    Visitor activationVisitor;
    int step = 0;

    public Model(Grid grid) {
        this.grid = grid;
        this.fireManager = new FireManager(this);
        colCount = grid.getColCount();
        rowCount = grid.getRowCount();
        paintingVisitor = new PaintingVisitor(grid);
        activationVisitor = new ActivationVisitor(this);
    }

    public void initialisation(int fireNumber, int fireFighterNumber) {
        for (int index = 0; index < fireNumber; index++)
            fireManager.fires.add(randomPosition());
        for (int index = 0; index < fireFighterNumber; index++)
            firefighters.add(randomPosition());
    }

    private Position randomPosition() {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

    public void activation() {
        ffNewPositions = new ArrayList<>();
        for (Position ff : firefighters) {
            FireFighter fireFighter = new FireFighter(ff);
            fireFighter.accept(activationVisitor);
            paintingVisitor.visitEmptyBox(new EmptyBox(new Position(ff.row(), ff.col())));
        }
        for (Position ff : ffNewPositions) {
            paintingVisitor.visitFireFighter(new FireFighter(new Position(ff.row(), ff.col())));
        }
        firefighters = ffNewPositions;
        if (step % 2 == 0) {
            fireManager.fireNewPositions = new ArrayList<>();
            for (Position fire : fireManager.fires) {
                Fire newFire = new Fire(fire);
                newFire.accept(activationVisitor);
            }
            for (Position fire : fireManager.fireNewPositions) {
                paintingVisitor.visitFire(new Fire(new Position(fire.row(), fire.col())));
            }
            fireManager.fires.addAll(fireManager.fireNewPositions);
        }
        step++;
    }

    private List<Position> activateFire(Position position) {
        return position.next(position, rowCount, colCount);
    }

    private Position activateFirefighter(Position position) {
        Position randomPosition = fireManager.aStepTowardFire(position);
        //next(position).get((int) (Math.random()*next(position).size()));
        List<Position> nextFires = position.next(randomPosition, rowCount, colCount).stream().filter(fireManager.fires::contains).toList();
        fireManager.extinguish(randomPosition);
        for (Position fire : nextFires)
            fireManager.extinguish(fire);
        return randomPosition;
    }
}
