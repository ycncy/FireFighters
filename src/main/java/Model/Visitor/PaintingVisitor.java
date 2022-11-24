package Model.Visitor;

import Model.Entity.*;
import Model.Visitor.Visitor;
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
        grid.getGraphicsContext2D().fillRect(fireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
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
        grid.getGraphicsContext2D().fillRect(motorizedFireFighter.getPosition().row() * grid.getGridHeight() / grid.getRowCount(),
                motorizedFireFighter.getPosition().col() * grid.getGridWidth() / grid.getColCount(),
                grid.getGridHeight() / grid.getRowCount(),
                grid.getGridWidth() / grid.getColCount());
    }


}
