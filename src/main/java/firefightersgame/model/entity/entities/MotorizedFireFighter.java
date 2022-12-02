package firefightersgame.model.entity.entities;

import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;

import java.util.List;

public class MotorizedFireFighter extends Entity {

    public MotorizedFireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitMotorizedFireFighter (this);
    }
}
