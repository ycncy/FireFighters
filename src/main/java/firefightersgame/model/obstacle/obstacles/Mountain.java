package firefightersgame.model.obstacle.obstacles;

import generalstructure.model.obstacle.Obstacle;
import generalstructure.view.paintingvisitor.PaintingVisitor;
import generalstructure.model.Position;
import javafx.scene.image.Image;

public class Mountain extends Obstacle {

    public Mountain (Position position) {
        super(position);
        this.image = new Image("C:\\Users\\talha\\IdeaProjects\\ProjetPCOO\\src\\main\\images\\mountain.png");
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitMountain(this);
    }
}
