package View.PaintingVistor;

import Model.Entity.Entities.*;
import Model.Obstacle.Obstacles.Mountain;
import Model.Obstacle.Obstacles.Road;
import View.Grid;
import javafx.scene.paint.Color;

public class PaintingVisitor implements Visitor {

    private final Grid grid;

    public PaintingVisitor(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void visitEmptyBox(EmptyBox emptyBox) {
        grid.getGraphicsContext2D().setFill(Color.WHITE);
        grid.getGraphicsContext2D().fillRect(emptyBox.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                emptyBox.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitFireFighter(FireFighter fireFighter) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        grid.getGraphicsContext2D().fillOval(fireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                fireFighter.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitFire(Fire fire) {
        grid.getGraphicsContext2D().setFill(Color.RED);
        grid.getGraphicsContext2D().fillRect(fire.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                fire.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitCloud(Cloud cloud) {
        grid.getGraphicsContext2D().setFill(Color.DARKGRAY);
        grid.getGraphicsContext2D().fillRect(cloud.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                cloud.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitMotorizedFireFighter(MotorizedFireFighter motorizedFireFighter) {
        grid.getGraphicsContext2D().setFill(Color.BLACK);
        grid.getGraphicsContext2D().fillOval(motorizedFireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                motorizedFireFighter.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitMountain(Mountain mountain) {
        grid.getGraphicsContext2D().setFill(Color.BROWN);
        grid.getGraphicsContext2D().fillRect(mountain.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                mountain.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }

    @Override
    public void visitRoad(Road road) {
        grid.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        grid.getGraphicsContext2D().fillRect(road.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                road.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }
}
