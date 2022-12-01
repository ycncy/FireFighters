package generalstructure.view.paintingvisitor;
import firefightersgame.model.entity.entities.*;
import firefightersgame.model.obstacle.obstacles.*;
import rockpaperscissors.model.entities.Paper;
import rockpaperscissors.model.entities.Rock;
import rockpaperscissors.model.entities.Scissors;

public interface PaintingVisitor {

    void visitEmptyBox (EmptyBox emptyBox);
    void visitFireFighter (FireFighter fireFighter);
    void visitFire (Fire fire);
    void visitCloud (Cloud cloud);
    void visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter);
    void visitMountain (Mountain mountain);
    void visitRoad (Road road);

    void visitRock (Rock rock);
    void visitPaper (Paper paper);
    void visitScissors (Scissors scissors);
}
