package Model.Visitor;

import Model.Entity.*;

public interface Visitor {

    void visitEmptyBox (EmptyBox emptyBox);
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
    void visitCloud (Cloud cloud);
    void visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter);
}
