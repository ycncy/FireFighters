package Model.Manager;

import Model.Entity.Fire;
import Util.Position;

public interface Extinguisher {

    Fire containsFire(Position position);
    void extinguishFire(Fire fire);
    Position aStepTowardFire (Position position, int rowCount, int colCount);
}
