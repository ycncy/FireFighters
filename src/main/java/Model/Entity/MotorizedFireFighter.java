package Model.Entity;

import Model.Visitor.Visitor;
import Util.Position;

public class MotorizedFireFighter extends Entity {

    public MotorizedFireFighter(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMotorizedFireFighter (this);
    }
}
