package generalstructure.model.entity;

import generalstructure.model.obstacle.ObstacleVisitor;
import generalstructure.model.Position;
import generalstructure.view.paintingvisitor.*;
import javafx.scene.image.Image;

import java.util.*;

public abstract class Entity {

    protected Position position;
    public Image image;

    public Entity(Position position) {
        this.position = position;
    }

    public abstract void accept(PaintingVisitor paintingVisitor);
    public abstract boolean accept(ObstacleVisitor obstacleVisitor, Position position);

    public List<Position> nextReachablePositions(int rowCount, int colCount, List<ObstacleVisitor> obstacleVisitors) {
        List<Position> list = new ArrayList<>();
        upperif:
        if (position.row() > 0) {
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!accept(obstacleVisitor, new Position(position.row() - 1, position.col()))) break upperif;
            }
            list.add(new Position(position.row() - 1, position.col()));
        }
        upperif:
        if (position.col() > 0) {
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!accept(obstacleVisitor, new Position(position.row(), position.col() - 1))) break upperif;
            }
            list.add(new Position(position.row(), position.col() - 1));
        }
        upperif:
        if (position.row() < rowCount - 1) {
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!accept(obstacleVisitor, new Position(position.row() + 1, position.col()))) break upperif;
            }
            list.add(new Position(position.row() + 1, position.col()));
        }
        upperif:
        if (position.col() < colCount - 1) {
            for (ObstacleVisitor obstacleVisitor : obstacleVisitors) {
                if (!accept(obstacleVisitor, new Position(position.row(), position.col() + 1))) break upperif;
            }
            list.add(new Position(position.row(), position.col() + 1));
        }
        return list;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return position != null ? position.equals(entity.position) : entity.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
