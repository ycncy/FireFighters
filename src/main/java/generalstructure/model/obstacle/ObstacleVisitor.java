package generalstructure.model.obstacle;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.Position;

public interface ObstacleVisitor {

    boolean visitEmptyBox (EmptyBox emptyBox, Position position);
    boolean visitFireFighter (FireFighter fireFighter, Position position);
    boolean visitFire (Fire fire, Position position);
    boolean visitCloud (Cloud cloud, Position position);
    boolean visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter, Position position);
}
