package View;

import Model.*;
import Model.Entity.EmptyBox;
import Model.Entity.Entity;
import Model.Entity.Fire;
import Model.Entity.FireFighter;
import Model.Manager.FireFighterManager;
import Model.Manager.FireManager;
import Model.Manager.Manager;
import Util.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Grid extends Canvas {

    private final int width, height, colCount, rowCount;
    private Model model;
    private final Visitor paintingVisitor;

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        paintingVisitor = new PaintingVisitor(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);

        FireManager fireManager = new FireManager(3);
        FireFighterManager fireFighterManager = new FireFighterManager(8, fireManager);

        model = new Model(rowCount, colCount, fireManager, fireFighterManager);
        model.initialisation();

    }

    public void restart(MouseEvent mouseEvent) {
        model = new Model(rowCount, colCount);
        model.initialisation();
        getGraphicsContext2D().clearRect(0, 0, width, height);
        repaint();
    }

    private void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        repaint();
            /*double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            model.click((int)x*rowCount/height,(int)y*colCount/width);*/
    }

    public void repaint() {
        for (int col = 0; col < colCount; col++) for (int row = 0; row < rowCount; row++) paintingVisitor.visitEmptyBox(new EmptyBox(new Position(row, col)));
        for (Manager manager : model.managers) for (Entity entity : manager.getEntities()) entity.accept (paintingVisitor);

        for (int col = 0; col < colCount; col++) getGraphicsContext2D().strokeLine(0, col * width / colCount, height, col * width / colCount);
        for (int row = 0; row < rowCount; row++) getGraphicsContext2D().strokeLine(row * height / rowCount, 0, row * height / rowCount, width);
    }

    public int getGridWidth() {
        return width;
    }

    public int getGridHeight() {
        return height;
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public Model getModel() {
        return model;
    }
}