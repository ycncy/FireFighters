package View.PaintingVistor;

import Model.Entity.Entities.*;
import Model.Obstacle.Obstacles.Mountain;
import Model.Obstacle.Obstacles.Road;

public interface Visitor {

    void visitEmptyBox (EmptyBox emptyBox);
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
    void visitCloud (Cloud cloud);
    void visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter);
    void visitMountain (Mountain mountain);
    void visitRoad (Road road);
}
