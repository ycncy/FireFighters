package firefightersgame.model.entity.entities;

import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

import java.util.List;

public class FireFighter extends Entity {

    public FireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitFireFighter(this);
    }
}
