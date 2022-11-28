package Model.Visitor.ObstacleVisitor;

import Model.Entity.Entities.*;
import Util.Position;

public interface ObstacleVisitor {

    boolean visitEmptyBox (EmptyBox emptyBox, Position position);
    boolean visitFireFighter (FireFighter fireFighter, Position position);
    boolean visitFire (Fire fire, Position position);
    boolean visitCloud (Cloud cloud, Position position);
    boolean visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter, Position position);
}
