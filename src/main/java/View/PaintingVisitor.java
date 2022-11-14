package View;

import Model.EmptyBox;
import Model.Fire;
import Model.FireFighter;
import Model.Visitor;
import javafx.scene.paint.Color;

public class PaintingVisitor implements Visitor {

    private Grid grid;

    public PaintingVisitor(Grid grid) {
        this.grid = grid;
    }

    public Grid getVisitorGrid() {
        return grid;
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
}