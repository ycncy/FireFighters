package firefightersgame.model.entity.entities;

import generalstructure.model.entity.Entity;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;

import java.util.List;

public class Cloud extends Entity {

    public Cloud (Position position) {
        super(position);
    }

    @Override
    public void accept (PaintingVisitor paintingVisitor) {
        paintingVisitor.visitCloud (this);
    }
}
