package rockpaperscissors.model.entities;

import generalstructure.model.entity.Entity;
import generalstructure.model.Position;
import generalstructure.view.paintingvisitor.PaintingVisitor;

public class Rock extends Entity {

    public Rock (Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitRock (this);
    }
}
