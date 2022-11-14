package Model;

import Model.EmptyBox;
import Model.Fire;
import Model.FireFighter;

public interface Visitor {

    void visitEmptyBox (EmptyBox emptyBox);
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
}
