package Grid;

import javafx.scene.paint.Color;

public class PaintingVisitor implements Visitor {

    @Override
    public void visitFireFighter(FireFighter fireFighter) {
        fireFighter.grid.getGraphicsContext2D().setFill(Color.BLUE);
        fireFighter.grid.getGraphicsContext2D().fillRect(
                fireFighter.position.row() * fireFighter.grid.getGridHeight() / fireFighter.grid.getRowCount(),
                fireFighter.position.col() * fireFighter.grid.getGridWidth() / fireFighter.grid.getColCount(),
                fireFighter.grid.getGridHeight() / fireFighter.grid.getRowCount(),
                fireFighter.grid.getGridWidth() / fireFighter.grid.getColCount());
    }

    @Override
    public void visitFire(Fire fire) {
        fire.grid.getGraphicsContext2D().setFill(Color.RED);
        fire.grid.getGraphicsContext2D().fillRect(
                fire.position.row() * fire.grid.getGridHeight() / fire.grid.getRowCount(),
                fire.position.col() * fire.grid.getGridWidth() / fire.grid.getColCount(),
                fire.grid.getGridHeight() / fire.grid.getRowCount(),
                fire.grid.getGridWidth() / fire.grid.getColCount());
    }

    @Override
    public void visitEmptyCase(EmptyCase emptyCase) {
        emptyCase.grid.getGraphicsContext2D().setFill(Color.WHITE);
        emptyCase.grid.getGraphicsContext2D().fillRect(
                emptyCase.position.row() * emptyCase.grid.getGridHeight() / emptyCase.grid.getRowCount(),
                emptyCase.position.col() * emptyCase.grid.getGridWidth() / emptyCase.grid.getColCount(),
                emptyCase.grid.getGridHeight() / emptyCase.grid.getRowCount(),
                emptyCase.grid.getGridWidth() / emptyCase.grid.getColCount());
    }
}
