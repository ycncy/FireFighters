package firefightersgame.model.entity.managers;

import firefightersgame.model.entity.entities.*;
import generalstructure.model.Position;

public interface Extinguisher {

    Fire containsFire(Position position);
    void extinguishFire(Fire fire);
    Position aStepTowardFire (Position position, int rowCount, int colCount);
}
