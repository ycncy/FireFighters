package firefightersgame.model.entity.entities;

import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

public class Fire extends Entity {

    public Fire(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitFire(this);
    }
}
