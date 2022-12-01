package firefightersgame.model.entity.entities;

import generalstructure.model.entity.Entity;
import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.view.paintingvisitor.*;
import generalstructure.model.Position;
import javafx.scene.image.Image;

public class Cloud extends Entity {

    public Cloud (Position position) {
        super(position);
        this.image = new Image("C:\\Users\\talha\\IdeaProjects\\ProjetPCOO\\src\\main\\images\\cloud.png");
    }

    @Override
    public void accept (PaintingVisitor paintingVisitor) {
        paintingVisitor.visitCloud (this);
    }

    @Override
    public boolean accept (ObstacleVisitor obstacleVisitor, Position position) {
        return obstacleVisitor.visitCloud(this, position);
    }
}
