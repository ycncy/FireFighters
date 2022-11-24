package Model;

import Util.Position;
import View.*;
import java.util.*;

public class Model {

    Grid grid;
    public FireManager fireManager;
    int colCount, rowCount;
    public List<Position> firefighters = new ArrayList<>();
    public List<Position> ffNewPositions;
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
            paintingVisitor.visitEmptyBox(new EmptyBox(ff));
            fireFighter.accept(activationVisitor);
        }
        firefighters = ffNewPositions;
        if (step % 2 == 0) {
            fireManager.fireNewPositions = new ArrayList<>();
            for (Position fire : fireManager.fires) {
                Fire newFire = new Fire(fire);
                newFire.accept(activationVisitor);
            }
            fireManager.fires.addAll(fireManager.fireNewPositions);
        }
        step++;
    }


}
