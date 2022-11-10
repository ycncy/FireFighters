package Grid;

public interface Visitor {
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
    void visitEmptyCase (EmptyCase emptyCase);
}
