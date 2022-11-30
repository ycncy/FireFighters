package firefightersgame.model.entity.entities;

import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import generalstructure.model.entity.Entity;
import javafx.scene.image.Image;

public class Fire extends Entity {

    public Fire(Position position) {
        super(position);
        this.image = new Image("C:\\Users\\talha\\IdeaProjects\\ProjetPCOO\\src\\main\\images\\fire.png");
    }

    @Override
    public void accept(PaintingVisitor paintingVisitor) {
        paintingVisitor.visitFire(this);
    }

    @Override
    public boolean accept(ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitFire(this, position);
    }
}
