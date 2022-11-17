package Model;

import Util.Position;

import java.util.ArrayList;
import java.util.List;

public class ActivationVisitor implements Visitor {

    Model model;

    public ActivationVisitor (Model model) {
        this.model = model;
    }

    @Override
    public void visitEmptyBox(EmptyBox emptyBox) {

    }

    @Override
    public void visitFireFighter(FireFighter fireFighter) {
        Position randomPosition = model.fireManager.aStepTowardFire(fireFighter.getPosition());
        List<Position> nextFires = fireFighter.getPosition().next(randomPosition, model.rowCount, model.colCount);
        model.fireManager.extinguish(randomPosition);
        for (Position fire : nextFires) {
            model.fireManager.extinguish(fire);
        }
        model.ffNewPositions.add(randomPosition);
    }

    @Override
    public void visitFire(Fire fire) {
        List<Position> newFires = new ArrayList<>(fire.getPosition().next(fire.getPosition(), model.rowCount, model.colCount));
        model.fireManager.fireNewPositions.addAll(newFires);
    }
}
