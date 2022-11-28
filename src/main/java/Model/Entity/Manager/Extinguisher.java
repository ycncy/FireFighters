package Model.Entity.Manager;

import Model.Entity.Entities.Fire;
import Util.Position;

public interface Extinguisher {

    Fire containsFire(Position position);
    void extinguishFire(Fire fire);
    Position aStepTowardFire (Position position, int rowCount, int colCount);
}
