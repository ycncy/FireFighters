package View;

import Model.Entity.EmptyBox;
import Model.Entity.Fire;
import Model.Entity.FireFighter;

public interface Visitor {

    void visitEmptyBox (EmptyBox emptyBox);
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
}
