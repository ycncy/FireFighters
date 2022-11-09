package Grid;

import javafx.scene.paint.Color;

public class ConcretePaintingVisitor implements PaintingVisitor {

    @Override
    public void visitFireFighter(FireFighter fireFighter) {
        fireFighter.grid.getGraphicsContext2D().setFill(Color.BLUE);
        fireFighter.grid.getGraphicsContext2D().fillRect(fireFighter.row*fireFighter.grid.getGridHeight()/fireFighter.grid.getRowCount(),
                fireFighter.col*fireFighter.grid.getGridWidth()/fireFighter.grid.getColCount(),
                fireFighter.grid.getGridHeight()/fireFighter.grid.getRowCount(),
                fireFighter.grid.getGridWidth()/fireFighter.grid.getColCount());
    }

    @Override
    public void visitFire(Fire fire) {
        fire.grid.getGraphicsContext2D().setFill(Color.RED);
        fire.grid.getGraphicsContext2D().fillRect(fire.row*fire.grid.getGridHeight()/fire.grid.getRowCount(),
                fire.col*fire.grid.getGridWidth()/fire.grid.getColCount(),
                fire.grid.getGridHeight()/fire.grid.getRowCount(),
                fire.grid.getGridWidth()/fire.grid.getColCount());
    }
}
